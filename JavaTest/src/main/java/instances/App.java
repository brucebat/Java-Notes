package instances;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/9/10 16:36
 */
public class App {
    public static void main(String[] args) {
        try {
            // 使用类型对象来完成对象创建，从
            Class<?> clazz = Class.forName("instances.Person");
            Person person = (Person) clazz.newInstance();
            System.out.println(person);
            // 使用构造函数进行对象实例创建
            Constructor<?> constructor = clazz.getConstructor();
            Person person2 = (Person) constructor.newInstance();
            System.out.println(person2);

            Person person3 = new Person();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
