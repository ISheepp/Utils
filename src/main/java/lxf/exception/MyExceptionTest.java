package lxf.exception;

import org.junit.Test;

/**
 * @author linzy
 * @create 2021-01-18 14:34:40
 */
public class MyExceptionTest {
    public static void main(String[] args) {
        String token = login("admin", "password");
        System.out.println("Token: " + token);
    }

    static String login(String username, String password) {
        if (username.equals("admin")) {
            if (password.equals("password")) {
                return "xxxxxx";
            } else {
                // 抛出LoginFailedException:
                throw new LoginException("Bad username or password.");
            }
        } else {
            // 抛出UserNotFoundException:
            throw new UserNotFoundException("User not found.");
        }
    }

    @Test
    public void test(){
        int num = -1;
        assert num >= 0;
        System.out.println(num);
    }
}
