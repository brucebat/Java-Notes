import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.List;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/9/27 4:54 下午
 */
public class TestMain {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            // 对应作者名称
            String authorName ="\"Sun Tianyu\"";
            String firstCommand = "git log --author=%s --pretty=tformat: --numstat ";
            firstCommand = String.format(firstCommand, authorName);
            String command = firstCommand + "| sort -u -n -r | awk '{ add += $1; subs += $2; loc += $1 - $2 } END { printf \"{\\\"addedLines\\\":%s,\\\"removedLines\\\":%s,\\\"totalLines\\\":%s}\", add, subs, loc }' -";
            // 如果存在管道指令则需要使用如下方式进行指令执行
            Process process = runtime.exec(new String[]{"/bin/sh", "-c", command});
            String result;
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "GBK");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((result = bufferedReader.readLine()) != null) {
                System.out.println(result);
            }
            String error;
            InputStreamReader errorInputStream = new InputStreamReader(process.getErrorStream(), "GBK");
            BufferedReader errorBufferedReader = new BufferedReader(errorInputStream);
            while ((error = errorBufferedReader.readLine()) != null) {
                System.out.println(error);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
