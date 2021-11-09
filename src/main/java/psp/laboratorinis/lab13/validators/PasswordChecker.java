package psp.laboratorinis.lab13.validators;

import psp.laboratorinis.lab13.validators.PasswordChecker;
import psp.laboratorinis.lab13.interfaces.Validator;
import psp.laboratorinis.lab13.helpers.Symbol;

import java.util.ArrayList;
import java.util.List;

public class PasswordChecker implements Validator {
    private List<Character> specialSymbols;
    private int minLength;
    private boolean needsUppercase = false;
    private boolean needsSpecialCharacters = false;

    public void minLength(int minLength) { this.minLength = minLength; }
    public void needsUppercase(){ needsUppercase = true; }
    public void needsSpecialCharacters(String specialCharacters)
    {
        specialSymbols = new ArrayList<>();
        for(char sentSymbol : specialCharacters.toCharArray()) {
            specialSymbols.add(sentSymbol);
        }
        needsSpecialCharacters = true;
    }

    public boolean validate(String password) {
        if (!isMinLength(password)) return false;
        if (needsUppercase && !containsUppercaseSymbol(password)) return false;
        return !needsSpecialCharacters || containsSpecialSymbol(password);
    }
    private boolean isMinLength(String password){
        return password.length() >= minLength;
    }

    private boolean containsUppercaseSymbol(String password){
        for(char symbol: password.toCharArray()) {
            if(Symbol.IsUppercase(symbol)) return true;
        }
        return false;
    }

    private boolean containsSpecialSymbol(String password){
        for(char specialSymbol: specialSymbols){
            if(password.contains(Character.toString(specialSymbol))) return true;
        }
        return false;
    }
}
