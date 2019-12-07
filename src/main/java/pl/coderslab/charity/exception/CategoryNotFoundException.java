package pl.coderslab.charity.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super("Category was not found");
    }
}
