package codesquad.service;

import codesquad.domain.Issue;
import codesquad.domain.IssueRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import support.test.BaseTest;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static codesquad.domain.IssueTest.issue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IssueServiceTest extends BaseTest {

    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssueService issueService;

    @Before
    public void setUp() throws Exception {
        when(issueRepository.findById(issue.getId())).thenReturn(Optional.of(issue));
    }

    @Test
    public void show() {
        Issue savedIssue = issueService.findById(issue.getId());
        softly.assertThat(savedIssue.hasSameSubjectAndComment(issue)).isEqualTo(true);
    }

    @Test(expected = EntityNotFoundException.class)
    public void show_없는이슈_찾을때() {
        issueService.findById(1000L);
    }
}