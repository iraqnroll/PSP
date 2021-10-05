package pair.main.java.interfaces.validators;

public interface ValidatorPhone extends Validator{
    boolean phoneContainsNumbersOnly(String phone);
    boolean phoneLengthCorrect(String phone);
    void addNewPhoneValidationRule(String prefix, Integer length);
}
