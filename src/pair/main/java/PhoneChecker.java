package pair.main.java;

import pair.main.java.interfaces.validators.ValidatorPhone;
import pair.main.java.interfaces.utils.PhoneUtils;

import java.util.HashMap;
import java.util.Map;

public class PhoneChecker implements ValidatorPhone, PhoneUtils {

    private HashMap<String, Integer> validationRules;
    private HashMap<String, String> internationalCodes;

    public PhoneChecker(HashMap<String, Integer> validationRules,
                        HashMap<String, String> internationalCodes)
    {
        this.validationRules = validationRules;
        this.internationalCodes = internationalCodes;
    }

    public boolean validate(String phone) {

        return phoneContainsNumbersOnly(phone) && phoneLengthCorrect(phone);
    }

    public void addNewPhoneValidationRule(String prefix, Integer length) {
        validationRules.put(prefix, length);
    }

    public boolean phoneContainsNumbersOnly(String phone) {
        return phone.chars().allMatch(ch -> Character.isDigit(ch) || ch == '+');
    }

    public String changeToInternationalCode(String phone) {
        for(Map.Entry m : internationalCodes.entrySet())
        {
            if(phone.contains((CharSequence) m.getKey()))
            {
                return (m.getValue() + phone.substring(((CharSequence) m.getKey()).length()));
            }
        }
        return phone;
    }

    public boolean phoneLengthCorrect(String phone) {
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
