package jsonPath;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

/**
 * 数据转化工具
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/10/18 4:45 下午
 */
public class DataTransformUtil {

    public static String objectToList() {
        return null;
    }

    public static void main(String[] args) {
        String source = "{\"name\":\"test\", \"age\":20}";
        // 这里是根据key的数量来确定最终list的数量，这里的key为两个，如何自动识别并且将对应的设置到object当中
        JSONObject sourceJson = JSONObject.parseObject(source);
        System.out.println(JSONPath.eval(sourceJson, "$.name"));
    }

}
