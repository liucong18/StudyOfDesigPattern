package proxy.cglibdynamicproxy;

/**
 * 目标对象
 * @author lc
 */
public class UserImpl implements User {
    @Override
    public void save() {
        System.out.println("保存用户全部信息成功。");
    }
}
