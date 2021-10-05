package ps.tests;

import ps.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorEmailTests {

    private EmailValidator emailValidator;

    @BeforeEach
    void setUp(){
        emailValidator = new EmailValidator();
    }

    @Test
    void email_NoAtSymbol_ReturnsFalse(){
        assertEquals(false, emailValidator.validate("testmail.com"));
    }

    @Test
    void email_HasAtSymbol_ReturnsTrue(){
        assertEquals(true, emailValidator.validate("test@mail.com"));
    }

    @Test
    void email_NoInvalidSymbols_ReturnsTrue(){
        assertEquals(true, emailValidator.validate("test@mail.com"));
    }

    @Test
    void email_HasInvalidSymbols_ReturnsFalse(){
        assertEquals(false, emailValidator.validate("test&@mail.com"));
    }

    @Test
    void email_HasInvalidDomain_ReturnsFalse(){
        assertEquals(false, emailValidator.validate("test@mail%.com"));
    }

    @Test
    void email_HasValidDomain_ReturnsTrue(){
        assertEquals(true, emailValidator.validate("test@mail.com"));
    }

    @Test
    void email_HasInvalidTLD_ReturnsFalse(){
        assertEquals(false, emailValidator.validate("test@mail.c#om"));
    }
}
