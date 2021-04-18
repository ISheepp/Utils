package schema.proxy;

/**
 * @author linzy
 * @create 2021-02-27 12:10:51
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
