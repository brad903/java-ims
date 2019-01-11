package codesquad.domain;

import codesquad.UnAuthorizedException;
import codesquad.domain.user.Avatar;
import codesquad.domain.user.User;
import org.junit.Test;
import support.test.BaseTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static support.test.Fixture.BRAD;

public class UserTest extends BaseTest {
    public static User newUser(Long id) {
        return new User(id, "userId", "password", "name", Avatar.DEFAULT_AVATAR);
    }

    public static User newUser(String userId) {
        return newUser(userId, "password");
    }

    public static User newUser(String userId, String password) {
        return new User(1L, userId, password, "name", Avatar.DEFAULT_AVATAR);
    }

    @Test
    public void update_owner() throws Exception {
        User origin = newUser("brad");
        User loginUser = origin;
        User target = new User("brad", "password", "name2", Avatar.DEFAULT_AVATAR);
        origin.update(loginUser, target);
        assertThat(origin.getName(), is(target.getName()));
    }

    @Test(expected = UnAuthorizedException.class)
    public void update_not_owner() throws Exception {
        User origin = newUser("leejh903");
        User loginUser = newUser("brad903");
        User target = new User("leejh903", "password", "name2", Avatar.DEFAULT_AVATAR);
        origin.update(loginUser, target);
    }

    @Test
    public void update_match_password() {
        User origin = newUser("leejh903");
        User target = new User("leejh903", "password", "name2", Avatar.DEFAULT_AVATAR);
        origin.update(origin, target);
        assertThat(origin.getName(), is(target.getName()));
    }

    @Test(expected = UnAuthorizedException.class)
    public void update_mismatch_password() {
        User origin = newUser("leejh903", "password2");
        User target = new User("leejh903", "password3", "name2", Avatar.DEFAULT_AVATAR);
        BRAD.update(origin, target);
    }

    @Test
    public void match_password() throws Exception {
        User user = newUser("leejh903");
        assertTrue(user.matchPassword(user.getPassword()));
    }

    @Test
    public void mismatch_password() throws Exception {
        User user = newUser("leejh903");
        assertFalse(user.matchPassword(user.getPassword() + "2"));
    }
}
