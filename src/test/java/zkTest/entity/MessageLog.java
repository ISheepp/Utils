package zkTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 林子洋
 * @create 2021-11-23 11:17:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageLog {

    public MessageLog(String stage, Integer num) {
        this.stage = stage;
        this.num = num;
    }

    private String stage;

    private Integer num;

    private List<String> fooList;

}
