package zkTest.fastjson;

/**
 * @author 林子洋
 * @create 2021-11-19 16:23:42
 */
public enum Status {

    Ready(10),

    Completed(20);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public static Status create(int value) {
        switch (value) {
            case 10:
                return Status.Ready;
            case 20:
                return Status.Completed;
            default:
                throw new RuntimeException("code error");
        }
    }

    public static int value(Status status) {
        return status.value;
    }

}
