package func.isheep;

import java.util.function.Function;

public class HikService {

    public static String fun(HikFunction hikFunction, Function<String, String> function) {
        String sss = function.apply("sss");
        System.err.println(sss);
        return hikFunction.getResult("fun", "22");
    }

    public static void main(String[] args) {
        System.out.println(fun((body, link) -> {
            String lzy = "123";
            return body + link;
        }, String::toLowerCase));
    }

}
