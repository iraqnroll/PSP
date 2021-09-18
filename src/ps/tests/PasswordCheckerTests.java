package ps.tests;

import ps.PasswordChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTests {

    private PasswordChecker passwordChecker;

    @BeforeEach
    void setUp(){
        passwordChecker = new PasswordChecker(5);
    }

    @Test
    void passwordLength_LengthLessThan5_ReturnsFalse(){
        assertEquals(false, passwordChecker.validate("test"));
    }

    @Test
    void passwordLength_LengthMoreThan5_ReturnsTrue(){
        assertEquals(true, passwordChecker.validate("password123"));
    }

    @Test
    void passwordSymbols_NoUppercaseSymbols_ReturnsFalse(){
        assertEquals(false, passwordChecker.validate("password123"));
    }

    @Test
    void passwordSymbols_HasUppercaseSymbols_ReturnsTrue(){
        assertEquals(true, passwordChecker.validate("Password123"));
    }

    @Test
    void passwordSymbols_NoSpecialSymbols_ReturnsFalse(){
        assertEquals(false, passwordChecker.validate("password123"));
    }

    @Test
    void passwordSymbols_HasSpecialSymbols_ReturnsTrue(){
        assertEquals(true, passwordChecker.validate("password!@123"));
    }
}
