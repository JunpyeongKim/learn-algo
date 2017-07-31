package lib;

public class OverflowException extends IllegalStateException {
    public OverflowException() {
        this("Overflow");
    }

    public OverflowException(String s) {
        super(s);
    }

    public OverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverflowException(Throwable cause) {
        super(cause);
    }
}
