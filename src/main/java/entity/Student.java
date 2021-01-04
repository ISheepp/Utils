package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author linzy
 * @create 2020-12-25 15:17:48
 */

public class Student {

    public Student(String name) {
        this.name = name;
    }

    private String name;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
