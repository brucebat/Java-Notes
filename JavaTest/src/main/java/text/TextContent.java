package text;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文本内容
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/2/16 3:50 下午
 */
@Data
public class TextContent implements Serializable {
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 描述
     */
    private String desc;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;

}
