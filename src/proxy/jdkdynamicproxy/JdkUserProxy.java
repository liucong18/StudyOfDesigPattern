package proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk实现的动态代理对象
 * @author lc
 */
public class JdkUserProxy {
    /**
     * 目标对象
     */
    private Object object;
    public JdkUserProxy(Object object) {
        this.object = object;
    }
    //生成代理对象
    public  Object getProxyInstance() {
        /*
         *  object.getClass().getClassLoader()：目标对象的类加载器
         *  object.getClass().getInterfaces()：目标对象的接口类型，jdk是通过接口实现的
         *  new InvocationHandler()：处理器
         */
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        // 执行目标对象方法
                        Object returnValue = method.invoke(object, args);
                        System.out.println("提交事务");
                        return null;
                    }
                });
    }
}
