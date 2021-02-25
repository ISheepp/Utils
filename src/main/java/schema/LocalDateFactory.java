package schema;

import java.time.LocalDate;

/**
 * @author linzy
 * @create 2021-02-25 23:02:33
 */
public class LocalDateFactory {

    public static LocalDate fromInt(int yyyyMMdd) {
        int year = yyyyMMdd / 10000;
        int month = yyyyMMdd % 10000 / 100;
        int dayOfMonth = yyyyMMdd % 100;
        return LocalDate.of(year, month, dayOfMonth);
    }

}
