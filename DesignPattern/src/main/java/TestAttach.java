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
            if (virtualMachineDescriptor.displayName().equals("App")) {
                System.out.println(virtualMachineDescriptor.id());
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
