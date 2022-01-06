package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 整型类型检查
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/8/11 10:28 下午
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface IntegerTypeCheck {

    /**
     * 名称
     *
     * @return 注解名称
     */
    String name() default "整型类型检查器";
}
