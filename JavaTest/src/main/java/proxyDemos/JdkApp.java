package proxyDemos;

import java.lang.reflect.Proxy;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/4/16 19:18
 */
public class JdkApp {

    public static void main(String[] args) {
        // 原始对象
        DemoService demoService = new DemoServiceImpl();
        // jdk代理执行过程
        JdkProxyHandler proxyHandler = new JdkProxyHandler(demoService);
        // 代理对象
        DemoService proxyService = (DemoService) Proxy.newProxyInstance(
                demoService.getClass().getClassLoader(),
                demoService.getClass().getInterfaces(),
                proxyHandler);
        // 代理对象调用对应方法
        proxyService.test();
    }
}
