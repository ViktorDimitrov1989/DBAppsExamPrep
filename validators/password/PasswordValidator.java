package app.validators.password;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {
    private boolean containsDigit;
    private boolean containsLowercase;
    private boolean containsUppercase;
    private int minLength;

    @Override
    public void initialize(Password password) {
        this.containsDigit = password.containsDigit();
        this.containsLowercase = password.containsLowerCase();
        this.minLength = password.minLength();
        this.containsUppercase = password.containsUpperCase();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password.length() < this.minLength){
            return false;
        }

        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher regex = pattern.matcher(password);
        if(!regex.find() && this.containsLowercase){
            return false;
        }

        Pattern digitPattern = Pattern.compile("[0-9]+");
        Matcher digitRegex = digitPattern.matcher(password);
        if(!digitRegex.find() && this.containsDigit){
            return false;
        }

        Pattern upperCasePattern = Pattern.compile("[A-Z]+");
        Matcher uppercaseRegex = upperCasePattern.matcher(password);
        if(!uppercaseRegex.find() && this.containsUppercase){
            return false;
        }

        return true;
    }
}
