package pair.main.java;

import pair.main.java.interfaces.validators.ValidatorPassword;

import java.util.List;

public class PasswordChecker implements ValidatorPassword {
    private int minLength;

    private List<Character> specialSymbols;

    public PasswordChecker(int minLength, List<Character> specialSymbols)
    {
        this.minLength = minLength;
        this.specialSymbols = specialSymbols;
    }

    public boolean validate(String password) {
        return passwordNotShorterThan(password)
                && passwordContainsUppercase(password)
                && passwordContainsSpecSymbol(password);
    }

    public boolean passwordNotShorterThan(String password) {

        return password.length() >= this.minLength;
    }

    public boolean passwordContainsUppercase(String password) {

        for(int i=0; i< password.length(); i++)
        {
            if(Character.isUpperCase(password.charAt(i)))
            {
                return true;
            }
        }

        return false;
    }

    public boolean passwordContainsSpecSymbol(String password) {

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
