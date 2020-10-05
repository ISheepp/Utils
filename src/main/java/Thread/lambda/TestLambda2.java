package Thread.lambda;

/**
 * @author lin
 * @create 2020-10-05 10:34
 */


public class TestLambda2 {
    public static void main(String[] args) {

        ILove love = (int a) -> {
            System.out.println("i love --> " + a);
        };
        love.love(520);

        //简化1.参数类型
        love = (a)->{
            System.out.println("i love you --> " + a);
        };

        //简化2。简化括号
        love = a -> {
            System.out.println("i love 521");
        };

        //简化3.去掉花括号
        love = a-> System.out.println("i love --> " + a);
        love.love(222);

        /**
         * 总结：
         * lambda表达式只有一行代码的情况下可以简化为一行，如果有多行，那么就使用代码块
         * 前提是接口为函数式接口
         * 多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号
         */
    }
}

interface ILove{
    void love(int a);
}
