package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import text.TextContent;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Gson序列化工具
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/2/16 3:41 下午
 */
public class GsonUtils {

    private static final Gson COMMON_GSON = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    /**
     * 根据对象转换成json
     *
     * @param data 待处理数据
     * @return 处理完成JSON
     */
    public static String toJsonString(Object data) {
        return COMMON_GSON.toJson(data);
    }

    /**
     * 根据JSON文本和指定类型进行JSON文本解析
     *
     * @param jsonString JSON文本
     * @param clazz      指定类型
     * @param <T>        返回对象泛型类
     * @return 解析完成对象
     */
    public static <T> T parseJson(String jsonString, Class<T> clazz) {
        return COMMON_GSON.fromJson(jsonString, clazz);
    }

    /**
     * 按照指定类型进行JSON文本解析处理
     *
     * @param jsonString 待解析JSON文本
     * @param type       带解析类型
     * @return 反序列化对象
     */
    public static Object parseJson(String jsonString, Type type) {
        return COMMON_GSON.fromJson(jsonString, type);
    }

    /**
     * 根据JSON文本内容进行对象解析
     *
     * @param jsonString 带解析JSON文本
     * @return 解析完成JSON文本
     */
    public static TextContent parseTextContent(String jsonString) {
        // 进行内容对象自定义解析，这里的自定义解析用在需要对json文本的读写做特殊处理的场景，如果没有这种需求，可以不使用这种方式
        Gson gson = new GsonBuilder().disableHtmlEscaping().registerTypeAdapter(TextContent.class, new TextContentAdapter()).create();
        return gson.fromJson(jsonString, TextContent.class);
    }

    public static void main(String[] args) {
        TextContent textContent = new TextContent();
        textContent.setTitle("This is a test!");
        textContent.setAuthor("Brucebat.Sun");
        textContent.setContent("This is a test. Just test a json tool--Gson.");
        textContent.setDesc("test content");
        textContent.setGmtCreate(new Date());
        textContent.setGmtModified(new Date());
        String text = toJsonString(textContent);
        System.out.println(text);
        TextContent parsedContent = parseJson(text, TextContent.class);
        System.out.println(parsedContent);
        System.out.println(parsedContent.getGmtCreate().getTime());
    }

}
