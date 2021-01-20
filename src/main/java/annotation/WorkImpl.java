package annotation;

/**
 * @author linzy
 * @create 2021-01-20 15:01:36
 */
public class WorkImpl implements Work {
    @Override
    public void stay() {
        System.out.println("stay");
    }

    @Override
    public String play() {
        System.out.println("play");
        return null;
    }

    public void implMethod() {
        System.out.println("implMethod");
    }

}
