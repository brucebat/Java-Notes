package annotation.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import java.util.List;
import java.util.Set;

/**
 * 整型类型检查
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/8/11 10:29 下午
 */
@SupportedAnnotationTypes("annotation.IntegerTypeCheck")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class IntegerTypeCheckProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getRootElements();
        if (null == elements || elements.isEmpty()) {
            return false;
        }
        for (Element element : elements) {
            System.out.println("当前元素名称为 : " + element.getSimpleName().toString());
            TypeElement typeElement = (TypeElement) element;
            List<? extends Element> enclosedElements = typeElement.getEnclosedElements();
            if (null == enclosedElements || enclosedElements.isEmpty()) {
                System.out.println("变量不存在");
                continue;
            }
            for (Element enclosedElement : enclosedElements) {
                System.out.println("当前变量名称为 : " + enclosedElement.getSimpleName());
                if (enclosedElement instanceof VariableElement) {
                    System.out.println("当前变量元素是field元素, 名称为 : " + enclosedElement.getSimpleName());
                }
            }
        }
        return false;
    }
}
