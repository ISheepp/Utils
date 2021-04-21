package nullDeal;

/**
 * @author linzy
 * @create 2021-04-20 10:56:46
 */
public class MyParser implements Parser {

    public static Action DO_NOTHING = () -> {
        /*do nothing*/
    };

    @Override
    public Action findAction(String userInput) {
        if (/*we can't find any action*/ true) {
            return DO_NOTHING;
        }
        return null;
    }
}
