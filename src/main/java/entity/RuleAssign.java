package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 林子洋
 * @create 2021-10-08 16:10:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleAssign {

    private Integer id;

    private String type;

    private String rule;

}
