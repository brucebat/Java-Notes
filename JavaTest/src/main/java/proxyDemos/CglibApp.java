package proxyDemos;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/4/20 11:35
 */
public class CglibApp {

    public static void main(String[] args) {
        // cglib方式实现的代理对象
        DemoBService demoBService = new DemoBService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DemoAService.class);
        enhancer.setCallback(new CglibInterceptor());

        DemoAService demoAServiceProxy = (DemoAService) enhancer.create();
        demoAServiceProxy.setDemoBService(demoBService);
        demoAServiceProxy.print();
    }
}
