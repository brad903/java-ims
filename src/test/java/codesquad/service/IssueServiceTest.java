package codesquad.service;

import codesquad.UnAuthorizedException;
import codesquad.domain.history.DeleteHistoryRepository;
import codesquad.domain.issue.Issue;
import codesquad.domain.issue.IssueRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import support.test.BaseTest;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static codesquad.domain.IssueTest.*;
import static codesquad.domain.UserTest.BRAD;
import static codesquad.domain.UserTest.JUNGHYUN;
import static codesquad.domain.LabelTest.LABEL;
import static codesquad.domain.MilestoneTest.MILESTONE;
import static org.mockito.Mockito.when;
import static org.slf4j.LoggerFactory.getLogger;

@RunWith(MockitoJUnitRunner.class)
public class IssueServiceTest extends BaseTest {
    private static final Logger log = getLogger(IssueServiceTest.class);

    @Mock
    private IssueRepository issueRepository;

    @Mock
    private DeleteHistoryRepository deleteHistoryRepository;

    @Mock
    private MilestoneService milestoneService;

    @Mock
    private UserService userService;

    @Mock
    private LabelService labelService;

    @InjectMocks
    private IssueService issueService;

    @Before
    public void setUp() throws Exception {
        when(issueRepository.findById(ISSUE.getId())).thenReturn(Optional.of(ISSUE));
        when(issueRepository.save(newIssue())).thenReturn(newIssue());
        when(milestoneService.findById(MILESTONE.getId())).thenReturn(MILESTONE);
        when(userService.findById(BRAD.getId())).thenReturn(BRAD);
        when(labelService.findById(LABEL.getId())).thenReturn(LABEL);
    }

    @Test
    public void show() {
        Issue savedIssue = issueService.findById(ISSUE.getId());
        softly.assertThat(savedIssue.hasSameBody(ISSUE.getIssueBody())).isEqualTo(true);
    }

    @Test(expected = EntityNotFoundException.class)
    public void show_없는이슈_찾을때() {
        issueService.findById(WRONG_ISSUE_ID);
    }

    @Test
    public void create() {
        Issue createdIssue = issueService.create(BRAD, ISSUE_BODY);
        softly.assertThat(createdIssue.isOwner(BRAD)).isEqualTo(true);
    }

    @Test(expected = EntityNotFoundException.class)
    public void update_없는이슈() {
        issueService.update(BRAD, WRONG_ISSUE_ID, UPDATE_ISSUE_BODY);
    }

    @Test(expected = UnAuthorizedException.class)
    public void update_다른유저() {
        issueService.update(JUNGHYUN, ISSUE.getId(), UPDATE_ISSUE_BODY);
    }

    @Test
    public void findById() {
        Issue issue = issueService.findById(BRAD, ISSUE.getId());
        softly.assertThat(issue.equals(ISSUE)).isTrue();
    }

    @Test(expected = UnAuthorizedException.class)
    public void findById_다른유저() {
        Issue issue = issueService.findById(JUNGHYUN, ISSUE.getId());
    }

    @Test
    public void delete() {
        issueService.deleteIssue(BRAD, ISSUE.getId());
        softly.assertThat(ISSUE.isDeleted()).isEqualTo(true);
    }

    @Test(expected = UnAuthorizedException.class)
    public void delete_다른유저() {
        issueService.deleteIssue(JUNGHYUN, ISSUE.getId());
        softly.assertThat(ISSUE.isDeleted()).isEqualTo(false);
    }

    @Test
    public void setMilestone() {
        Issue issue = issueService.setMilestone(BRAD, ISSUE.getId(), MILESTONE.getId());
        softly.assertThat(issue.hasSameMilestone(MILESTONE)).isTrue();
    }

    @Test
    public void setAssignee() {
        Issue issue = issueService.setAssignee(BRAD, ISSUE.getId(), BRAD.getId());
        softly.assertThat(issue.isAssignee(BRAD)).isTrue();
    }

    @Test
    public void setLabel() {
        Issue issue = issueService.setLabel(BRAD, ISSUE.getId(), LABEL.getId());
        softly.assertThat(issue.hasSameLabel(LABEL)).isTrue();
    }
}