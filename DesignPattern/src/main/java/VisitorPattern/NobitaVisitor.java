package VisitorPattern;

import java.util.Objects;

/**
 * 野比大雄
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/4 11:04 下午
 */
public class NobitaVisitor extends AbstractVisitor {

    @Override
    public void visit(ExaminePaper examinePaper) {
        if (!Objects.nonNull(examinePaper)) {
            return;
        }
        if (!"Nobita".equals(examinePaper.getName())) {
            return;
        }
        if (Objects.nonNull(examinePaper.getScore()) && 0 == examinePaper.getScore()) {
            System.out.println("大雄内心独白：惊恐！然后大喊：他死开台，哆啦A梦！");
        }
    }
}
