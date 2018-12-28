package codesquad.web;

import codesquad.domain.Issue;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import support.test.AcceptanceTest;

import static codesquad.domain.IssueTest.issues;
import static org.slf4j.LoggerFactory.getLogger;

public class HomeControllerTest extends AcceptanceTest {
    private static final Logger log = getLogger(HomeControllerTest.class);

    @Test
    public void home() {
        ResponseEntity<String> responseEntity = template.getForEntity("/", String.class);
        softly.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        for (Issue issue : issues) {
            softly.assertThat(responseEntity.getBody().contains(issue.getSubject()));
        }
    }
}