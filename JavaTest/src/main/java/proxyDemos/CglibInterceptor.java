package proxyDemos;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 拦截器方法处理
 *
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/4/18 11:14
 */
public class CglibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("method handle start!");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("method handle end!");
        return null;
    }
}
