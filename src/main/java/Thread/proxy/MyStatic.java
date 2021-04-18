package Thread.proxy;

/**
 * @author linzy
 * @create 2021-03-17 12:03:37
 */
public class MyStatic {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumberImpl();
        MyProxylzy proxylzy = new MyProxylzy(myNumber);
        proxylzy.printa();
    }
}

interface MyNumber {
    void printa();
}

class MyNumberImpl implements MyNumber {
    @Override
    public void printa() {
        System.out.println("lzyhahaha");
    }
}

class MyProxylzy implements MyNumber {

    private final MyNumber number;

    public MyProxylzy(MyNumber number) {
        this.number = number;
    }

    @Override
    public void printa() {
        System.out.println("hahaha");
        number.printa();
        System.out.println("hahahahahahha");
    }
}
