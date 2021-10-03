package pair.main.java;

import java.util.ArrayList;
import java.util.List;

public class PasswordChecker {
    private int minLength;

    private List<Character> specialSymbols;

    public PasswordChecker(int minLength, List<Character> specialSymbols)
    {
        this.minLength = minLength;
        this.specialSymbols = specialSymbols;
    }

    public boolean validatePassword(String password) {
        return passwordNotShorterThan(password)
                && passwordContainsUppercase(password)
                && passwordContainsSpecSymbol(password);
    }

    private boolean passwordNotShorterThan(String password) {

        return password.length() >= this.minLength;
    }

    private boolean passwordContainsUppercase(String password) {

        for(int i=0; i< password.length(); i++)
        {
            if(Character.isUpperCase(password.charAt(i)))
            {
                return true;
            }
        }

        return false;
    }

    private boolean passwordContainsSpecSymbol(String password) {

        for(int i=0; i < password.length(); i++)
        {
            for(char c : specialSymbols)
            {
                if(password.charAt(i) == c)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
