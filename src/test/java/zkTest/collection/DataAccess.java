package zkTest.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 林子洋
 * @create 2021-09-06 14:51:29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DataAccess {

    private String fieldName;

    private String reportDate;

    private Float percent;

}
