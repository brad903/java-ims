package support.fixture;

import codesquad.domain.history.ContentType;
import codesquad.domain.history.DeleteHistory;
import codesquad.domain.issue.Comment;
import codesquad.domain.issue.Issue;
import codesquad.domain.issue.IssueBody;

import java.util.ArrayList;
import java.util.List;

import static support.fixture.UserFixture.BRAD;
import static support.fixture.UserFixture.JUNGHYUN;

public class IssueFixture {
    public static final long WRONG_ISSUE_ID = 100L;
    public static final long DEFAULT_ISSUE_ID = 0L;
    public static final List<Issue> ISSUES = new ArrayList<>();
    public static final IssueBody ISSUE_BODY = new IssueBody("테스트 이슈1", "테스트 이슈 내용입니다1");
    public static final Issue ISSUE = new Issue(1L, ISSUE_BODY, BRAD);
    public static final IssueBody ISSUE_BODY2 = new IssueBody("테스트 이슈2", "테스트 이슈 내용입니다2");
    public static final Issue ISSUE2 = new Issue(2L, ISSUE_BODY2, BRAD);
    public static final IssueBody ISSUE_BODY3 = new IssueBody("테스트 이슈3", "테스트 이슈 내용입니다3");
    public static final Issue ISSUE3 = new Issue(3L, ISSUE_BODY3, JUNGHYUN);
    public static final IssueBody UPDATE_ISSUE_BODY = new IssueBody("업데이트 이슈 제목", "업데이트 이슈 내용입니다");
    public static final IssueBody NEW_ISSUE_BODY = new IssueBody("새로운 테스트 이슈 제목", "새로운 테스트 이슈 내용입니다");

    public static long RANDOM_COMMENT_ID = 100L;
    public static final String CONTENTS = "답변내용입니다1";
    public static final Comment COMMENT = new Comment(1L, CONTENTS, ISSUE, BRAD);
    public static final String CONTENTS2 = "답변내용입니다2";
    public static final Comment COMMENT2 = new Comment(2L, CONTENTS2, ISSUE, BRAD);
    public static final String CONTENTS3 = "답변내용입니다3";
    public static final Comment COMMENT3 = new Comment(3L, CONTENTS3, ISSUE, BRAD);
    public static final String NEW_CONTENTS = "새로운 답변내용입니다";
    public static final String UPDATE_CONTENTS = "새로운 답변내용입니다";
    public static final List<Comment> COMMENTS = new ArrayList<>();

    public static final DeleteHistory DELETE_HISTORY = new DeleteHistory(ContentType.ISSUE, ISSUE.getId(), BRAD);

    static {
        ISSUES.add(ISSUE);
        ISSUES.add(ISSUE2);
        ISSUES.add(ISSUE3);

        COMMENTS.add(COMMENT);
        COMMENTS.add(COMMENT2);
        COMMENTS.add(COMMENT3);
        ISSUE.getComments().addAll(COMMENTS);
    }
}
