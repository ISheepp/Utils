package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linzy
 * @create 2020-12-25 15:17:48
 */

public class Student implements Serializable {

    private static final long serialVersionUID = -6958371550480988469L;

    public Student(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Student(String name, String price, Date date) {
        // 这将调用另一个构造器方法
        this("lzy", "111");
        this.date = date;
    }

    private String name;

    public String price;

    private Date date;

    public Date getDate() {
        // 引用类型使用clone的方式
        return (Date) date.clone();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
