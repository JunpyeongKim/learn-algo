package lib;

public class UnderflowException extends IllegalStateException {

    public UnderflowException() {
        this("Underflow");
    }

    public UnderflowException(String s) {
        super(s);
    }

    public UnderflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnderflowException(Throwable cause) {
        super(cause);
    }
}
