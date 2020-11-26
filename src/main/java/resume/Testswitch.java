package resume;

/**
 * @author ISheep
 * @create 2020-11-25 21:41:05
 */
public class Testswitch {

    public static void main(String[] args) {
        int type = 2;
        int count = 0;
        switch (type){
            case 1:
                count += 1;
            case 2:
                count += 2;
            case 3:
                count += 3;
            default:
                count += 9;
        }
        System.out.println(count);
    }

}
