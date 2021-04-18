
/**
 * @author lin
 * @create 2020-09-30 14:31
 */
public class Main {
    public static void main(String[] args) {
        new Square(4);
    }
}

class Polygon {
    void cal() {
        System.out.println("polygon.call()");
    }

    Polygon() {
        System.out.println("polygon before cal()");
        cal();
        System.out.println("polygon after cal()");
    }

}

class Square extends Polygon {
    private int border = 2;

    Square(int i) {
        border = i;
        System.out.println("square.square()" + border);
    }

    @Override
    void cal() {
        System.out.println("square.cal()" + border);
    }
}
