package zkTest.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 林子洋
 * @create 2021-09-07 10:51:08
 */
@Data
public class TaskInspectDTO {

    String taskName;
    String describe;

    TaskState sourceState;
    TaskState transformState;
    TaskState sinkState;

    public TaskInspectDTO(String taskName) {
        this.taskName = taskName;
    }

    @Getter
    @Setter
    public static class TaskState {
        private String type;
        private String state;
        private Boolean isHealth;

        public TaskState(String state, Boolean isHealth) {
            this.type = type;
            this.state = state;
            this.isHealth = isHealth;
        }
    }
}
