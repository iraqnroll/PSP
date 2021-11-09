package psp.laboratorinis.lab13.validators;

import java.util.ArrayList;
import java.util.List;

import psp.laboratorinis.lab13.helpers.*;
import psp.laboratorinis.lab13.interfaces.*;

public class EmailValidator implements Validator {
    private final List<Character> allowedSymbols = new ArrayList<>(List.of('\'','!','#', '$', '%', '&', '*', '+', '-', '/', '=', '?', '^', '_', '{', '|'));
    private final List<String> allowedDomains = new ArrayList<>(List.of("@gmail.com"));

    public boolean validate(String email){
        if(!email.contains("@")) return false;
        if(!hasName(email)) return false;
        if(containsForbiddenSymbol(email)) return false;
        if(!hasValidDomain(email)) return false;
        return !hasForbiddenSymbols(email);
    }

    private boolean hasForbiddenSymbols(String email){
        for(char symbol: email.toCharArray()){
            if(Symbol.IsLetter(symbol)) break;
            if(Symbol.IsNumber(symbol)) break;
            if(allowedSymbols.contains(symbol)) break;

            return true;
        }
        return false;
    }

    private boolean containsForbiddenSymbol(String email){
        for(char symbol: email.toCharArray()) {
            if(email.contains(Character.toString(symbol))) return false;
        }
        return true;
    }

    private boolean hasValidDomain(String email){
        boolean hasValidDomain = false;
        String domain = email.substring(email.indexOf('@'));

        for(String validDomain : allowedDomains){
            if (domain.equals(validDomain)) {
                hasValidDomain = true;
                break;
            }
        }
        return hasValidDomain;
    }

    private boolean hasName(String email){
        return email.indexOf('@') != 0;
    }
}
