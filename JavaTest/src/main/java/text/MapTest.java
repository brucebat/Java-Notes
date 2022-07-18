package text;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/7/15 10:04
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("test", "test");
        // 这里即使后面写了value或者key其实没有任何意义，最终复制的依然是value
        map.computeIfAbsent("test", (value) -> "test".concat("Value"));
        map.computeIfAbsent("test", (key) -> "test".concat("Key"));
        System.out.println(map);

        DynamicType.Unloaded<?> dynamicType = new ByteBuddy().subclass(Object.class).make();
        Map<TypeDescription, byte[]> allTypes = dynamicType.getAllTypes();
        for (TypeDescription typeDefinition : allTypes.keySet()) {
            // 此处如果没有主动
            System.out.println(typeDefinition.getTypeName());
        }
    }
}
