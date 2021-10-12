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
        System.out.println("premian: 这是一个实验用的DemoAgent");
        System.out.println("premian: " + Thread.currentThread().getThreadGroup().getName() + ", threadId: " + Thread.currentThread().getId());
        System.out.println("premian, 当前线程是否为保护线程: " + Thread.currentThread().isDaemon());
        instrumentation.addTransformer(new DefineTransformer());

    }

    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("agnetmain: 这是一个实验用的DemoAgent, 线程名称为: " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName() + ", threadId: " + Thread.currentThread().getId());
        System.out.println("当前线程是否为保护线程: " + Thread.currentThread().isDaemon());
    }

    /**
     * 这里会针对所有加载进JVM当中的class文件进行转化
     */
    static class DefineTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            // classfileBuffer
            if (null == className || 0 == className.length()) {
                return classfileBuffer;
            }
            if (!className.contains("App")) {
                return classfileBuffer;
            }
            System.out.println("premain load Class:" + className);
            // 这里获取的编译后的二进制文件，通过修改/替换对应的二进制文件我们可以对原有的类新增一些新的功能
//            System.out.println("premain load Class filer: " + new String(classfileBuffer));
            // 这里只是提供了一个入口可以去感知到对应的class文件，如果想要对class文件进行实际的变更可以使用javaassist或者Byte Code等工具，也可以直接针对上面的字节数据进行修改
            return classfileBuffer;
        }
    }

}
