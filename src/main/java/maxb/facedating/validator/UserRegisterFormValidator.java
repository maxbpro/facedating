package maxb.facedating.validator;

import maxb.facedating.domain.Feedback;
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
public class UserRegisterFormValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String ID_PATTERN = "[0-9]+";
    String STRING_PATTERN = "[a-zA-Z]+";
    String MOBILE_PATTERN = "[0-9]{10}";

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz) || Feedback.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.userForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.userForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userForm.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");

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


        if (!(user.getEmail() != null && user.getEmail().isEmpty())) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(user.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", "Pattern.userForm.email");
            }
        }



//        if (!(user.getPhoneNumber() != null && user.getPhoneNumber().isEmpty())) {
//            pattern = Pattern.compile(MOBILE_PATTERN);
//            matcher = pattern.matcher(user.getPhoneNumber());
//            if (!matcher.matches()) {
//                errors.rejectValue("phoneNumber", "Pattern.userForm.phoneNumber");
//            }
//        }





        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
        }



    }
}
