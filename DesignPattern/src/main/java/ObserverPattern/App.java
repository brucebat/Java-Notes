package ObserverPattern;

import ObserverPattern.listener.CommonListener;
import ObserverPattern.listener.StudentListener;
import ObserverPattern.source.Teacher;

/**
 * 观察者模式--启动类
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/7 10:23 下午
 */
public class App {

    public static void main(String[] args) {
        // 观察对象
        AbstractTrafficLight trafficLight = new RedLight();
        // 观察者
        Car car, car1;
        car = new Bicycle();
        trafficLight.attach(car);
        car1 = new Truck();
        trafficLight.attach(car1);
        trafficLight.notice();

        // 事件驱动模式
        // 事件源
        Teacher teacher = new Teacher();
        // 事件监听器--学生
        CommonListener student = new StudentListener();
        // 事件监听器--家长
        CommonListener parent = event -> System.out.println("通知学生进行" + event.getEventName() + "操作");
        // 注册监听器
        teacher.addListener(student);
        teacher.addListener(parent);
        // 发布事件
        teacher.commandPlay();
        teacher.commandStudy();
    }
}
