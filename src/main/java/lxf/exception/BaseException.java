package lxf.exception;

/**
 * @author linzy
 * @create 2021-01-18 14:24:18
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -2078272166564687481L;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

}
