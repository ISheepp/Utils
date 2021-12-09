package zkTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 林子洋
 * @create 2021-11-24 13:42:27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortDomain {

    private Integer sortValue;

    private String name;

}
