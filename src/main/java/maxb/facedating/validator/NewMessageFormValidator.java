package maxb.facedating.validator;

import maxb.facedating.domain.Message;
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
public class NewMessageFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Message.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "NotEmpty.postForm.text");
    }
}
