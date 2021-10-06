package VisitorPattern;

import java.util.Objects;

/**
 * 老师
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/4 11:09 下午
 */
public class TeacherVisitor extends AbstractVisitor {

    @Override
    public void visit(ExaminePaper examinePaper) {
        if (!Objects.nonNull(examinePaper)) {
            return;
        }
        if (Objects.nonNull(examinePaper.getScore()) && 0 == examinePaper.getScore()) {
            System.out.println("老师：孺子不可教也，朽木不可雕也！");
        }
    }
}
