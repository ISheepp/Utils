package schema.proxy;

/**
 * @author linzy
 * @create 2021-02-27 12:09:55
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务"); // 额外扩展功能
        target.save();
        System.out.println("提交事务");
    }
}
