package pair.test.java;

import org.junit.jupiter.api.Test;
import pair.main.java.PasswordChecker;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {
    PasswordChecker passwordChecker = new PasswordChecker(7,
            Arrays.asList('@','!','#','$'));

    @Test
    void passwordNotShorterThan_shouldPass() {
        String password = "Pass@123";

        boolean result = passwordChecker.validate(password);

        assertTrue(result);
    }

    @Test
    void passwordNotShorterThan_shouldFail() {
        String password = "Pass@1";

        boolean result = passwordChecker.validate(password);

        assertFalse(result);
    }

    @Test
    void passwordContainsUppercase_shouldPass() {
        String password = "Pass@123";

        boolean result = passwordChecker.validate(password);

        assertTrue(result);
    }

    @Test
    void passwordContainsUppercase_shouldFail() {
        String password = "pass@123";

        boolean result = passwordChecker.validate(password);

        assertFalse(result);
    }

    @Test
    void passwordContainsSpecSymbol_shouldPass() {
        String password = "Pass@123";

        boolean result = passwordChecker.validate(password);

        assertTrue(result);
    }

    @Test
    void passwordContainsSpecSymbol_shouldFail() {
        String password = "Pass123";

        boolean result = passwordChecker.validate(password);

        assertFalse(result);
    }
}