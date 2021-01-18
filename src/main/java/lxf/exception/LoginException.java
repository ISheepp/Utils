package lxf.exception;

/**
 * @author linzy
 * @create 2021-01-18 14:26:47
 */
public class LoginException extends BaseException {

    private static final long serialVersionUID = 4584906798718348152L;


    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}
