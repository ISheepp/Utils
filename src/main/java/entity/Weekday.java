package entity;

/**
 * @author linzy
 * @create 2021-01-15 13:34:21
 * 星期枚举类
 */
public enum Weekday {
    SUN(0),
    MON(1),
    TUE(2),
    WED(3),
    THU(4),
    FRI(5),
    SAT(6);

    private final int dayValue;

    public int getDayValue() {
        return dayValue;
    }

    Weekday(int dayValue) {
        this.dayValue = dayValue;
    }

    public static void main(String[] args) {
        System.out.println("Weekday.MON = " + Weekday.MON);
        Weekday sat = Weekday.SAT;
    }

}

