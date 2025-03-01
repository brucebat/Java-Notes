package chainResponsibilityPattern;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/3/1 18:14
 */
public class Main {

    public static void main(String[] args) {
        AbstractHandler stringHandler = new StringHandler();
        AbstractHandler intHandler = new IntegerHandler();
        stringHandler.setNextHandler(intHandler);

        try {
            stringHandler.handle(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            stringHandler.handle("hello, world");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
