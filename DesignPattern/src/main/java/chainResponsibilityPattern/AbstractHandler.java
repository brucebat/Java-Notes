package chainResponsibilityPattern;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/3/1 18:00
 */
public abstract class AbstractHandler {

    private AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler handler) {
        this.nextHandler = handler;
    }

    public void handle(Object target) throws Exception {

        if (canHandle(target)) {
            doHandle(target);
            return;
        }
        if (null == nextHandler) {
            throw new Exception();
        }
        nextHandler.handle(target);
    }


    public abstract boolean canHandle(Object target);

    public abstract void doHandle(Object target);
}
