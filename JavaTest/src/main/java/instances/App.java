package instances;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/9/10 16:36
 */
public class App {
    public static void main(String[] args) {
//        try {
//            // 使用类型对象来完成对象创建，从
//            Class<?> clazz = Class.forName("instances.Person");
//            Person person = (Person) clazz.newInstance();
//            System.out.println(person);
//            // 使用构造函数进行对象实例创建
//            Constructor<?> constructor = clazz.getConstructor();
//            Person person2 = (Person) constructor.newInstance();
//            System.out.println(person2);
//
//            Person person3 = new Person();
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
//                 InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
        testFuture();
    }


    private static void testFuture() {
        // TODO 这里需要思考一个问题，在使用CompleteFuture进行并发处理时是否会出现线程数量爆炸的情况，然后我们会发现jdk考虑了这样一个情况，
        //  我们可以将用于管理线程的线程池对应作为入参传入到方法体中。
        String testText = "This is a test.";
        // 这里可以设置使用线程池
        // 无返回结果，只会进行异步处理
        CompletableFuture.runAsync(() -> System.out.println("runAsync: " + testText));
        // 主线程中的处理逻辑
        System.out.println("main: " + testText);
        // 有返回结果， 同时通过链式结构我们可以获取到针对结果进行不断地处理
        CompletableFuture<String> testFutureTask = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync: " + testText);
            return testText + " SupplyAsync. ";
        }).thenApply(text -> text + "Then apply.");
        try {
            // 在完成其他处理逻辑之后进行阻塞式的获取
            String test = testFutureTask.get(2000, TimeUnit.MILLISECONDS);
            System.out.println(test);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        // 这里我们需要思考在什么场景中适合使用CompleteFuture，实际上只有遇到重IO的操作才需要使用CompleteFuture来完成对于业务逻辑和IO操作的分离以及并行操作
    }
}
