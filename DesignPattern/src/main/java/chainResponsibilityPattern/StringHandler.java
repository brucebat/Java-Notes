package chainResponsibilityPattern;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/3/1 18:08
 */
public class StringHandler extends AbstractHandler {

    @Override
    public boolean canHandle(Object target) {
        return target instanceof String;
    }

    @Override
    public void doHandle(Object target) {
        System.out.println("This is a String : " + target);
    }
}
