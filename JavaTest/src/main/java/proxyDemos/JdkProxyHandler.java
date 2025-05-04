package proxyDemos;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/4/16 19:12
 */
public class JdkProxyHandler implements InvocationHandler {

    private final Object target;

    public JdkProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start proxy handle!");
        Object result = method.invoke(target, args);
        System.out.println("end proxy handle!");
        return result;
    }
}
