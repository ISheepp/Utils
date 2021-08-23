package aenum;

/**
 * @author 林子洋
 * @create 2021-08-23 13:56:10
 */
public enum Color {

    RED(2, 1),
    GREEN(3, 2);

    int value;

    int num;

    Color(int value, int num) {
        this.value = value;
        this.num = num;
    }
}
