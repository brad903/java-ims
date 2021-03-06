package codesquad.web.issue;

import codesquad.domain.issue.Issue;
import codesquad.domain.user.User;
import codesquad.domain.issue.IssueBody;
import codesquad.security.LoginUser;
import codesquad.service.IssueService;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/api/issues")
public class ApiIssueController {
    private static final Logger log = getLogger(ApiIssueController.class);

    @Resource(name = "issueService")
    private IssueService issueService;

    @PostMapping("")
    public ResponseEntity<Void> create(@LoginUser User loginUser, @Valid @RequestBody IssueBody issueBody) {
        Issue savedIssue = issueService.create(loginUser, issueBody);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/issues/" + savedIssue.getId()));
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Issue show(@PathVariable long id) {
        return issueService.findById(id);
    }

    @PutMapping("/{id}")
    public Issue update(@LoginUser User loginUser, @PathVariable long id, @Valid @RequestBody IssueBody updateIssueBody) {
        return issueService.update(loginUser, id, updateIssueBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@LoginUser User loginUser, @PathVariable long id) {
        issueService.deleteIssue(loginUser, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{issueId}/milestones/{milestoneId}")
    public ResponseEntity<Void> setMilestone(@LoginUser User loginUser, @PathVariable long issueId, @PathVariable long milestoneId) {
        issueService.setMilestone(loginUser, issueId, milestoneId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{issueId}/assignees/{assigneeId}")
    public ResponseEntity<Void> setAssignee(@LoginUser User loginUser, @PathVariable long issueId, @PathVariable long assigneeId) {
        issueService.setAssignee(loginUser, issueId, assigneeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{issueId}/labels/{labelId}")
    public ResponseEntity<Void> setLabel(@LoginUser User loginUser, @PathVariable long issueId, @PathVariable long labelId) {
        issueService.setLabel(loginUser, issueId, labelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
