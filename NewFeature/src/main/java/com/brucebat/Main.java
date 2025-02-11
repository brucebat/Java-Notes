package com.brucebat;

import com.beust.jcommander.Parameter;
import com.brucebat.common.Demo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 尝试创建一个cli应用程序
 *
 * @author brucebat
 * @version 1.0
 * @since Created at ${DATE} ${TIME}
 */
public class Main {

    @Parameter(names = {"--length", "-l"})
    private int length;
    @Parameter(names = {"--pattern", "-p"})
    private int pattern;
    public static void main(String[] args) {
        // 这里使用的工具只是一个解析命令行的工具，并不是实际的能够生成一个运行时监听命令的程序
//        Main main = new Main();
//        JCommander.newBuilder().addObject(main).build().parse(args);
//        main.run();
//        int[] nums = new int[5];
//        System.out.println(Arrays.toString(nums));
//        HashMap<String, String> map = new HashMap<>();
//        map.put("a", "hello");
//        map.put("b", "world");
//
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        Demo demo = new Demo();
        demo.setCount(12);
        demo.setName("test");
        Path path = Paths.get("test.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(demo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Demo newDemo = (Demo) ois.readObject();
            System.out.println(newDemo.getName());
            System.out.println(newDemo.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.printf("%d %d", length, pattern);
    }
}