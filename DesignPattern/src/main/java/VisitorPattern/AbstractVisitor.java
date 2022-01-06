package VisitorPattern;

/**
 * 抽象访问者
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/4 10:56 下午
 */
public abstract class AbstractVisitor {

    /**
     * 访问考生的试卷
     *
     * @param examinePaper 试卷
     */
    public abstract void visit(ExaminePaper examinePaper);
}
