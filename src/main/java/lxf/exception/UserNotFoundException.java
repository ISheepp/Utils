package lxf.exception;

/**
 * @author linzy
 * @create 2021-01-18 14:35:14
 */
public class UserNotFoundException extends BaseException {

    private static final long serialVersionUID = 6191648986836756830L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
