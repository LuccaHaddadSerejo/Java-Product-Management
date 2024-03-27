package exceptions;

public class UniqueNameException extends Exception {
    public UniqueNameException() {
        super("This product name already exists.");
    }

    public UniqueNameException(String message) {
        super(message);
    }
}
