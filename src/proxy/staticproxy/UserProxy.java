package proxy.staticproxy;

/**
 * 代理类
 * @author lc
 */
public class UserProxy implements User{

    private UserImpl user;
    /**
     * 在构造方法里把目标类的对象注入
     */
    public UserProxy(UserImpl user) {
        this.user = user;
    }

    /**
     * 重写save方法，对目标对象进行加工，对目标对象的功能进行加工
     */
    @Override
    public void save() {
        System.out.println("开启事务。");
        user.save();
        System.out.println("关闭事务。");
    }
}
