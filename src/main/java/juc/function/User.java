package juc.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author linzy
 * @create 2021-03-03 23:00:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    private String name;

    private int age;
}
