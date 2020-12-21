import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ISheep
 * @Date 2020/9/29 19:29
 * @Version 1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;

    private String sex;

    private Integer face;

}
