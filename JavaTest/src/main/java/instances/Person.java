package instances;

import lombok.Data;

import java.io.Serializable;

/**
 * 人
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/9/10 16:37
 */
@Data
public class Person implements Serializable {

    /**
     * 名称
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private Integer age;
}
