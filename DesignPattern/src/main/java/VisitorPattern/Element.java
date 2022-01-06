package VisitorPattern;

/**
 * 被访问元素
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/4 10:57 下午
 */
public abstract class Element {

    /**
     * 用于接收访问者的方法
     *
     * @param abstractVisitor 抽象访问者
     */
    public abstract void accept(AbstractVisitor abstractVisitor);
}
