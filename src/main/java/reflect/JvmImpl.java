package reflect;

import annotation.Report;

/**
 * @author 林子洋
 * @create 2021-09-01 10:59:13
 */
@Report
public class JvmImpl implements TestJvmOne, TestJvmTwo {

    @Override
    public String getOne() {
        return "one";
    }

    @Override
    public String getTwo() {
        return "two";
    }
}
