package maxb.facedating.validator;

import maxb.facedating.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MaxB on 08/11/2017.
 */
@Component
public class UserUpdateFormValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    String STRING_PATTERN = "[a-zA-Z]+";


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.userForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.userForm.lastName");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "NotEmpty.userForm.birthdate");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "about", "NotEmpty.userForm.about");

        // input string conatains characters only
        if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {
            pattern = Pattern.compile(STRING_PATTERN);
            matcher = pattern.matcher(user.getFirstName());
            if (!matcher.matches()) {
                errors.rejectValue("firstName", "firstname.containNonChar");
            }
        }

        if (!(user.getLastName() != null && user.getLastName().isEmpty())) {
            pattern = Pattern.compile(STRING_PATTERN);
            matcher = pattern.matcher(user.getLastName());
            if (!matcher.matches()) {
                errors.rejectValue("lastName", "lastname.containNonChar");
            }
        }




    }
}
