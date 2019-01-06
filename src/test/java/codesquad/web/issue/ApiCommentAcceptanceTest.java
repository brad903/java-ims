package codesquad.web.issue;

import codesquad.domain.issue.Comment;
import codesquad.domain.issue.IssueRepository;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import support.test.AcceptanceTest;

import static codesquad.domain.IssueTest.ISSUE;
import static codesquad.domain.UserTest.BRAD;
import static codesquad.domain.issue.CommentTest.CONTENTS;
import static org.slf4j.LoggerFactory.getLogger;

public class ApiCommentAcceptanceTest extends AcceptanceTest {
    private static final Logger log = getLogger(ApiCommentAcceptanceTest.class);

    @Autowired
    private IssueRepository issueRepository;

    @Test
    public void create() {
        String url = String.format("/api/issues/%d/comments", ISSUE.getId());
        String location = createResource(url, BRAD, new Comment(CONTENTS));
        Comment comment = template().getForObject(location, Comment.class);
        softly.assertThat(comment.getContents()).isEqualTo(CONTENTS);
        softly.assertThat(comment.getWriter()).isEqualTo(BRAD);
        log.debug("comment : {}", comment);
    }

    @Test
    public void delete() {
        String url = String.format("/api/issues/%d/comments", ISSUE.getId());
        String location = createResource(url, BRAD, new Comment(CONTENTS));
        ResponseEntity<Void> response = basicAuthTemplate().exchange(location, HttpMethod.DELETE, createHttpEntity(null), Void.class);
        softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}