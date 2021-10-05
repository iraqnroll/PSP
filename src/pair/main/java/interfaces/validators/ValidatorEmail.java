package pair.main.java.interfaces.validators;

public interface ValidatorEmail extends Validator{
    public boolean emailContainsAtSign(String email);
    public boolean emailHasCorrectDomain(String email);
    public boolean emailHasCorrectLocalPart(String email);
}
