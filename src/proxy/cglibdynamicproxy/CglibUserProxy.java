package proxy.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib包下的动态代理
 * @author lc
 */
public class CglibUserProxy implements MethodInterceptor {
    /**
     * 目标对象
     */
    private Object object;
    public CglibUserProxy(Object object) {
        this.object = object;
    }
    //生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(object.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }
    /**
     * 重写cglib包下的代理对象增强方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        // 执行目标对象的方法
        Object returnValue = method.invoke(object, objects);
        System.out.println("关闭事务");
        return null;
    }
}
