package pair.test.java;

import org.junit.jupiter.api.Test;
import pair.main.java.EmailValidator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private List<Character> localPartSymbols = Arrays.asList(
            '1','2','3','4','5','6','7','8','9','0','-');

    private List<Character> domainPartSymbols = Arrays.asList(
            '1','2','3','4','5','6','7','8','9','0',
            '+','-','_','~','@','.','!','#','$','%',
            '&','\'','/','=','?','^','`','{','|','}');

    EmailValidator emailValidator = new EmailValidator(
            64,
            63,
            localPartSymbols,
            domainPartSymbols
    );

    @Test
    void emailContainsAtSign_shouldPass() {
        String email = "email@mail.com";

        boolean result = emailValidator.validateEmail(email);

        assertTrue(result);
    }

    @Test
    void emailContainsAtSign_shouldFail() {
        String email = "emailmail.com";

        boolean result = emailValidator.validateEmail(email);

        assertFalse(result);
    }

    @Test
    void emailDoesNotContainInvalidSymbols_shouldPass() {
        String email = "email@mail.com";

        boolean result = emailValidator.validateEmail(email);

        assertTrue(result);
    }

    @Test
    void emailDoesNotContainInvalidSymbols_shouldFail() {
        String email = "email@ mail.com";

        boolean result = emailValidator.validateEmail(email);

        assertFalse(result);
    }

    @Test
    void emailHasCorrectDomain_shouldPass() {
        String email = "email@mail.com";

        boolean result = emailValidator.validateEmail(email);

        assertTrue(result);
    }

    @Test
    void emailHasCorrectDomain_shouldFail() {
        String email = "email@wrong domain.com";

        boolean result = emailValidator.validateEmail(email);

        assertFalse(result);
    }

    @Test
    void emailHasCorrectTld_ShouldPass() {
        String email = "email@mail.com";

        boolean result = emailValidator.validateEmail(email);

        assertTrue(result);
    }

    @Test
    void emailHasCorrectTld_ShouldFail() {
        String email = "email@mail.com wrong";

        boolean result = emailValidator.validateEmail(email);

        assertFalse(result);
    }
}