package pl.coderslab.charity.exception;

public class InstitutionNotFoundException extends RuntimeException {
    public InstitutionNotFoundException() {
        super("Institution was not found");
    }
}
