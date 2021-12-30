/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/10 5:40 下午
 */
public class App {

    public static void main(String[] args) {
        doSomething();
    }

    public static void doSomething() {
        System.out.println(Thread.currentThread().getName() + ", 这是一个java agent测试类");
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName() + ", ThreadId: " + Thread.currentThread().getId());
    }
}
