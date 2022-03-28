package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/26 4:53 PM
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Integer> integerMap = new HashMap<>();
        // 从这个实验中我们可以看到，HashMap当中想要从链表转换成红黑树还是比较困难的
        for (int i = 0; i < 500; i++) {
            integerMap.put(UUID.randomUUID().toString(), i);
        }
    }
}
