package proxy.jdkdynamicproxy;

import proxy.staticproxy.UserProxy;

/**
 * jdk动态代理测试类
 * @author lc
 */
public class Test {

    public static void main(String[] s) {
        //目标对象
        UserImpl user = new UserImpl();
        /*
         *  代理对象,把目标对象注入给代理对象；
         *  这里只能用目标对象的接口强制转换，因为得到的代理对象和目标对象继承于同一接口，
         *  属于同级类，不能强转(就像狗可以强转成动物，但不能强转成猫)
         */
        User jdkUserProxy = (User)new JdkUserProxy(user).getProxyInstance();
        //使用目标对象实现功能
        System.out.println("使用目标对象实现功能:");
        user.save();
        //使用代理对象实现功能
        System.out.println();
        System.out.println("使用代理对象实现功能:");
        jdkUserProxy.save();
        System.out.println(jdkUserProxy.getClass());
    }
}
