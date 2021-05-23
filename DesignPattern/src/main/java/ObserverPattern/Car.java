package ObserverPattern;

/**
 * 观察者模式中的观察者（接口）--汽车
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/7 9:19 下午
 */
public interface Car {

    /**
     * 汽车启动方法
     */
    void start();

    /**
     * 汽车停止方法
     */
    void stop();
}
