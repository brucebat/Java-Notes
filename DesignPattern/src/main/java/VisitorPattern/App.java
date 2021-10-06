package VisitorPattern;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/4 11:03 下午
 */
public class App {

    public static void main(String[] args) {
        ExaminePaper nobitaPaper = new ExaminePaper();
        nobitaPaper.setName("Nobita");
        nobitaPaper.setScore(0);
        nobitaPaper.accept(new TeacherVisitor());
        nobitaPaper.accept(new NobitaVisitor());
        nobitaPaper.accept(new MomVisitor());
    }
}
