package psp.laboratorinis.lab13.validators;

import psp.laboratorinis.lab13.validators.PhoneValidator;
import psp.laboratorinis.lab13.interfaces.Validator;
import psp.laboratorinis.lab13.helpers.Symbol;

import java.util.ArrayList;
import java.util.List;

public class PhoneValidator implements Validator {
    private int length = 12;
    private String prefix = "+370";
    private List<String> prefixVariations = new ArrayList<>(List.of("8"));

    public void length(int length) { this.length = length; }
    public void prefix(String prefix) { this.prefix = prefix; }
    public void prefixVariations(List<String> prefixVariations) { this.prefixVariations = prefixVariations; }


    public boolean validate(String phone) {
        phone = transformPhone(phone);
        if(containsForbiddenSymbols(phone)) return false;
        if(!hasGoodStructure(phone)) return false;
        return hasGoodStructure(phone);
    }

    private String transformPhone(String phone)
    {
        for(String prefixVariation : prefixVariations) {
            if(phone.startsWith(prefixVariation))
                return prefix + phone.substring(prefixVariation.length());
        }
        return phone;
    }

    private boolean containsForbiddenSymbols(String phone)
    {
        for(char symbol: phone.toCharArray())
            if (!Symbol.IsNumber(symbol) && symbol != '+') return true;

        return false;
    }

    private boolean hasGoodStructure(String phone)
    {
        if(phone.length() != length) return false;
        return phone.startsWith(prefix);
    }

    private boolean IsNumber(char symbol)
    {
        return (symbol >= '0' && symbol <= '9');
    }
}
