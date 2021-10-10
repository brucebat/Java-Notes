package agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Demo Agent
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/9/27 4:45 下午
 */
public class DemoAgent {

    /**
     * 在主线程启动之前进行处理
     *
     * @param agentArgs       代理请求参数
     * @param instrumentation 插桩
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("这是一个实验用的DemoAgent");
        instrumentation.addTransformer(new DefineTransformer(), true);
    }

    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("这是一个实验用的DemoAgent");
    }

    static class DefineTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            System.out.println("premain load Class:" + className);
            return classfileBuffer;
        }
    }

}
