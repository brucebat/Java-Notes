package xml;

import java.util.ArrayList;
import java.util.List;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/11/19 16:00
 */
public class App {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("media");
        test.add("mediaTwo");
        test.add("mediaThree");
        System.out.println(test.subList(0, 2));
    }
}
