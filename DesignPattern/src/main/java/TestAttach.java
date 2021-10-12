import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.io.IOException;
import java.util.List;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/10 8:21 下午
 */
public class TestAttach {

    public static void main(String[] args) throws IOException, AttachNotSupportedException {
        List<VirtualMachineDescriptor> virtualMachineDescriptors = VirtualMachine.list();
        for (VirtualMachineDescriptor virtualMachineDescriptor : virtualMachineDescriptors) {
            System.out.println("vm displayName : " + virtualMachineDescriptor.displayName());
            if (virtualMachineDescriptor.displayName().equals("App")) {
                System.out.println(virtualMachineDescriptor.id());
                // 这里最终要的一点就是不需要通过使用命令行的方式去指定需要监测的JVM进程, 可以通过较为明确的虚拟机名称来进行设置
                VirtualMachine virtualMachine = VirtualMachine.attach(virtualMachineDescriptor.id());
                try {
                    virtualMachine.loadAgent("JavaBasic/target/JavaBasic-1.0.0-SNAPSHOT-jar-with-dependencies.jar");
                    System.out.println("ok");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    virtualMachine.detach();
                }
            }
        }
    }
}
