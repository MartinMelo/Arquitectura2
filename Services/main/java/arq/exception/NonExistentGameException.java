package arq.exception;

public class NonExistentGameException extends MarketRuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public NonExistentGameException() {
        super("NonExistentGame", "That game does not exist");
    }
}
