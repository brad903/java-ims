package codesquad.domain;

import codesquad.domain.user.Avatar;
import codesquad.domain.user.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static support.test.ValidationTest.VALIDATOR;

public class UserValidationTest {
    private static final Logger log = LoggerFactory.getLogger(UserValidationTest.class);

    @Test
    public void userIdWhenIsEmpty() throws Exception {
        User user = new User("", "password", "name", Avatar.DEFAULT_AVATAR);
        Set<ConstraintViolation<User>> constraintViolcations = VALIDATOR.validate(user);
        assertThat(constraintViolcations.size(), is(1));

        for (ConstraintViolation<User> constraintViolation : constraintViolcations) {
            log.debug("violation error message : {}", constraintViolation.getMessage());
        }
    }
}
