package VisitorPattern;

import java.util.Objects;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/4 11:12 下午
 */
public class MomVisitor extends AbstractVisitor {

    @Override
    public void visit(ExaminePaper examinePaper) {
        if (!Objects.nonNull(examinePaper)) {
            return;
        }
        if (!"Nobita".equals(examinePaper.getName())) {
            return;
        }
        if (Objects.nonNull(examinePaper.getScore()) && 0 == examinePaper.getScore()) {
            System.out.println("妈妈：不把你打的满脸桃花开，你怕是不知道花儿为什么这么红");
        }
    }
}
