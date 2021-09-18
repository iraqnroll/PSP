package ps;

public class PhoneValidator {

    private String countryPrefix;
    private int length;

    public PhoneValidator(String countryPrefix, int length)
    {
        this.countryPrefix = countryPrefix;
        this.length = length;
    }
    public boolean validate(String number) {
        return false;
    }
}
