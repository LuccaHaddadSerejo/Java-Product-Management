package exceptions;

public class NegativePriceException extends Exception {
    public NegativePriceException(){
        super("Negative price.");
    }

    public NegativePriceException(String message){
        super(message);
    }
}
