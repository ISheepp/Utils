package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林子洋
 * @create 2021-08-01 13:40:47
 */

@Data
public class SerStudent implements Serializable {

    private static final long serialVersionUID = -7062700499651099269L;

    private String name;

    private Date date;

}
