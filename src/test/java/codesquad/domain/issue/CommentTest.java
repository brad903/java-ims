package codesquad.domain.issue;

import org.junit.Test;
import support.test.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static codesquad.domain.IssueTest.ISSUE;
import static codesquad.domain.UserTest.BRAD;

public class CommentTest extends BaseTest {
    public static long RANDOM_COMMENT_ID = 100L;
    public static final String CONTENTS = "답변내용입니다1";
    public static final Comment COMMENT = new Comment(1L, CONTENTS, ISSUE, BRAD);
    public static final String CONTENTS2 = "답변내용입니다2";
    public static final Comment COMMENT2 = new Comment(2L, CONTENTS2, ISSUE, BRAD);
    public static final String CONTENTS3 = "답변내용입니다3";
    public static final Comment COMMENT3 = new Comment(3L, CONTENTS3, ISSUE, BRAD);
    public static final String NEW_CONTENTS = "새로운 답변내용입니다";
    public static final List<Comment> COMMENTS = new ArrayList<>();

    static {
        COMMENTS.add(COMMENT);
        COMMENTS.add(COMMENT2);
        COMMENTS.add(COMMENT3);
    }

    @Test
    public void delete() {
        COMMENT.delete(BRAD, ISSUE);
        softly.assertThat(COMMENT.isDeleted()).isTrue();
    }
}