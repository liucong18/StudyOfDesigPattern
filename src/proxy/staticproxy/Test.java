package proxy.staticproxy;

/**
 * 测试类
 * @author lc
 */
public class Test {

    public static void main(String[] s) {
        //目标对象
        UserImpl user = new UserImpl();
        //代理对象,把目标对象注入给代理对象
        UserProxy userProxy = new UserProxy(user);
        //使用目标对象实现功能
        System.out.println("使用目标对象实现功能:");
        user.save();
        //使用代理对象实现功能
        System.out.println();
        System.out.println("使用代理对象实现功能:");
        userProxy.save();
    }
}
