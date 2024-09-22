package exceptions;


/**
 * It occurs when the required book is not available
 * It's a subclass of RuntimeException because we can prevent it with if-else condition
 */
public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException() {
        this("Book isn't available");
    }

    public BookNotAvailableException(String message) {
        super(message);
    }

    public BookNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotAvailableException(Throwable cause) {
        super(cause);
    }

    public BookNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
