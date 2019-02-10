package proxy.cglibdynamicproxy;

/**
 * cglib包下的动态代理
 * @author lc
 */
public class Test {

    public static void main(String[] s) {
        UserImpl user = new UserImpl();
        User cglibUserProxy = (User)new CglibUserProxy(user).getProxyInstance();
        //使用目标对象实现功能
        System.out.println("使用目标对象实现功能:");
        user.save();
        //使用代理对象实现功能
        System.out.println();
        System.out.println("使用代理对象实现功能:");
        cglibUserProxy.save();
        System.out.println(cglibUserProxy.getClass());
    }
}
