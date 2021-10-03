package pair.main.java;

import java.util.HashMap;
import java.util.Map;

public class PhoneValidator {

    private HashMap<String, Integer> validationRules;
    private HashMap<String, String> internationalCodes;

    public PhoneValidator(HashMap<String, Integer> validationRules,
                          HashMap<String, String> internationalCodes)
    {
        this.validationRules = validationRules;
        this.internationalCodes = internationalCodes;
    }

    public boolean validatePhone(String phone) {

        return phoneContainsNumbersOnly(phone) && phoneLengthCorrect(phone);
    }

    public void addNewPhoneValidationRule(String prefix, Integer length) {
        validationRules.put(prefix, length);
    }

    private boolean phoneContainsNumbersOnly(String phone) {
        return phone.chars().allMatch(ch -> Character.isDigit(ch) || ch == '+');
    }

    private String changeToInternationalCode(String phone) {
        for(Map.Entry m : internationalCodes.entrySet())
        {
            if(phone.contains((CharSequence) m.getKey()))
            {
                return (m.getValue() + phone.substring(((CharSequence) m.getKey()).length()));
            }
        }
        return phone;
    }

    private boolean phoneLengthCorrect(String phone) {
        for(Map.Entry m : validationRules.entrySet())
        {
            if(phone.contains((CharSequence) m.getKey()))
            {
                var number = phone.substring(((CharSequence) m.getKey()).length()).length();
                if(m.getValue().equals(number))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
