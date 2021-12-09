package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 林子洋
 * @create 2021-11-10 10:30:28
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSource {

    private String name;

    private long size;

}
