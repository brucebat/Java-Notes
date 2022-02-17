package utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import text.TextContent;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

/**
 * 文本内容适配器
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/2/16 5:58 下午
 */
public class TextContentAdapter extends TypeAdapter<TextContent> {

    @Override
    public void write(JsonWriter out, TextContent value) throws IOException {
        // 自定义JSON解析逻辑
    }

    @Override
    public TextContent read(JsonReader in) throws IOException {
        final TextContent textContent = new TextContent();
        // 自定义JSON反解析逻辑
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "title":
                    textContent.setTitle(in.nextString());
                    break;
                case "author":
                    textContent.setAuthor(in.nextString());
                    break;
                case "desc":
                    textContent.setDesc(in.nextString());
                    break;
                case "content":
                    textContent.setContent(in.nextString());
                    break;
                case "gmtCreate":
                    try {
                        textContent.setGmtCreate(DateFormat.getTimeInstance().parse(in.nextString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "gmtModified":
                    try {
                        textContent.setGmtModified(DateFormat.getTimeInstance().parse(in.nextString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        in.endObject();
        return textContent;
    }
}
