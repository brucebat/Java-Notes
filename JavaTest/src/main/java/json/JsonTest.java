package json;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/3 11:36 AM
 */
public class JsonTest {

    public static void main(String[] args) {
        JSONObject data = new JSONObject();
        data.put("name", "bruce");
        handleJson(data);
        System.out.println(data.toJSONString());
    }

    /**
     * 通过测试可以看出此时data在方法内部是不可以重新赋值的，但是引用对象的内容是可以进行变更的.
     * 但是对于基本类型数据，如果加上final关键词后是不能进行变更的。
     *
     * @param data 待处理数据
     */
    private static void handleJson(final JSONObject data) {
        if (Objects.isNull(data) || data.size() == 0) {
            return;
        }
        data.put("name", "test");
        System.out.println(data.toJSONString());
    }
}
