package pair.main.java.interfaces.validators;

public interface ValidatorPassword extends Validator{
    public boolean passwordNotShorterThan(String password);
    public boolean passwordContainsUppercase(String password);
    public boolean passwordContainsSpecSymbol(String password);
}
