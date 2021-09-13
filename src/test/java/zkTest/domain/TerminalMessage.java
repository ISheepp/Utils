package zkTest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import zkTest.collection.DataAccess;

/**
 * 小站、雷达数据格式
 *
 * @author 林子洋
 * @create 2021-09-07 14:34:23
 */
@Data
@Accessors(chain = true)
public class TerminalMessage<T> {

    public TerminalMessage() {}

    public TerminalMessage(Stage stage) {
        this.stage = stage;
    }

    public TerminalMessage(Stage stage, T data) {
        this.stage = stage;
        this.data = data;
    }

    public TerminalMessage(Long startTime, Long endTime, Stage stage, T data) {
        this.stage = stage;
        this.data = data;
        if ("radar".equals(stage.name())) {
            this.radarStartTime = startTime;
            this.radarEndTime = endTime;
        }
        this.microStartTime = startTime;
        this.microEndTime = endTime;
    }

    /**
     * 雷达发送日志时间
     */
    private Long radarStartTime;

    /**
     * 雷达接收日志时间
     */
    private Long radarEndTime;

    /**
     * 小站发送日志时间
     */
    private Long microStartTime;

    /**
     * 小站接收日志时间
     */
    private Long microEndTime;

    /**
     * 发送阶段
     */
    private Stage stage;

    /**
     * 源数据
     */
    private T data;

    /**
     * 发送阶段枚举
     */
    public enum Stage {

        /**
         * 雷达
         */
        RADAR(),

        /**
         * 小站
         */
        MICRO()

    }

    public static void main(String[] args) {
        TerminalMessage<DataAccess> obj = new TerminalMessage<>(123L, 145L, Stage.MICRO, new DataAccess());
        System.out.println(obj);
    }

}
