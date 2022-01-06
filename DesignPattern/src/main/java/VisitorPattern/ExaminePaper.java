package VisitorPattern;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 试卷
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/4 11:00 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExaminePaper extends Element {

    /**
     * 考生名字
     */
    private String name;
    /**
     * 分数
     */
    private Integer score;

    @Override
    public void accept(AbstractVisitor abstractVisitor) {
        abstractVisitor.visit(this);
    }
}
