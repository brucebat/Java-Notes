package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式中的观察目标（抽象类）--交通灯
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/7 9:17 下午
 */
public abstract class AbstractTrafficLight {

    /**
     * 观察当前目标的的观察者集合
     */
    protected List<Car> cars = new ArrayList<>();

    /**
     * 向观察者集合中添加观察者
     *
     * @param car 观察者
     */
    public void attach(Car car) {
        cars.add(car);
    }

    /**
     * 从观察者集合中删除观察者
     *
     * @param car 观察者
     */
    public void detach(Car car) {
        cars.remove(car);
    }

    /**
     * 通知集合中观察者
     */
    public abstract void notice();
}
