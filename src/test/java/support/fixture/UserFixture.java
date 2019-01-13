package support.fixture;

import codesquad.domain.user.Avatar;
import codesquad.domain.user.User;

public class UserFixture {
    public static final String DEFAULT_USER_ID = "testuser";
    public static final User BRAD = new User(1L, "brad903", "password", "Brad", Avatar.DEFAULT_AVATAR);
    public static final User JUNGHYUN = new User(2L, "leejh903", "password", "이정현", Avatar.DEFAULT_AVATAR);
}
