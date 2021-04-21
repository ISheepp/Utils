package nullDeal;

/**
 * @author linzy
 * @create 2021-04-20 10:55:29
 */
public interface Parser {

    /**
     * 根据用户输入找到并执行相应的动作
     * @param userInput 用户输入
     * @return action
     */
    Action findAction(String userInput);

}
