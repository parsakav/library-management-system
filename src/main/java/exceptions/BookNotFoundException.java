package exceptions;
/**
 * It occurs when the required book not found
 * It's a subclass of RuntimeException because we can prevent it with if-else condition
 */
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        this("Book not found");
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }

    public BookNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
