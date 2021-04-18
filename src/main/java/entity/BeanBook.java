package entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linzy
 * @create 2021-02-04 11:11:00
 */
@Data
@Accessors(chain = true)
public class BeanBook {

    private String name1;

    private Double price;

    private String description;

    public static String test() {

        return "sss";
    }

}
