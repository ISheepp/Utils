package Thread.proxy;

/**
 * @author lin
 * @create 2020-10-04 20:54
 */

//静态代理模式总结
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色
//
public class StaticProxy {

    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();

    }

}

interface Marry{
    void HappyMarry();
}

//真实角色
class You implements Marry{

    public void HappyMarry() {
        System.out.println("林老师要结婚了");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry{

    //代理谁->真实目标对象
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    public void HappyMarry() {
        before();
        this.target.HappyMarry(); //这就是真实对象
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}