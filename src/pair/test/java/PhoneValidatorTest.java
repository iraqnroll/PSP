package pair.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pair.main.java.PhoneValidator;
import ps.EmailValidator;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorTest {

    public HashMap<String, Integer> validationRules;

    private HashMap<String, String> internationalCodes;

    PhoneValidator phoneValidator;

    @BeforeEach
    void setUp(){
        validationRules = new HashMap<String, Integer>();
        internationalCodes = new HashMap<String, String>();

        validationRules.put("+370", 8);
        internationalCodes.put("8", "+370");

        phoneValidator = new PhoneValidator(validationRules, internationalCodes);
    }

    @Test
    void phoneContainsNumbersOnly_shouldPass() {
        String phone = "+37000000000";

        boolean result = phoneValidator.validatePhone(phone);

        assertTrue(result);
    }

    @Test
    void phoneContainsNumbersOnly_shouldFail() {
        String phone = "+3700000000a";

        boolean result = phoneValidator.validatePhone(phone);

        assertFalse(result);
    }

    @Test
    void phoneStartsWith_shouldPass() {
        String phone = "+37000000000";

        boolean result = phoneValidator.validatePhone(phone);

        assertTrue(result);
    }

    @Test
    void phoneStartsWith_shouldFail() {
        String phone = "-37000000000";

        boolean result = phoneValidator.validatePhone(phone);

        assertFalse(result);
    }

    @Test
    void phoneLengthCorrect_shouldPass() {
        String phone = "+37000000000";

        boolean result = phoneValidator.validatePhone(phone);

        assertTrue(result);
    }

    @Test
    void phoneLengthCorrect_shouldFail() {
        String phone = "+370";

        boolean result = phoneValidator.validatePhone(phone);

        assertFalse(result);
    }
}