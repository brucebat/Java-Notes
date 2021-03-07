package ObserverPattern;

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
        TrafficLight trafficLight = new RedLight();
        // 观察者
        Car car, car1;
        car = new Bicycle();
        trafficLight.attach(car);
        car1 = new Truck();
        trafficLight.attach(car1);
        trafficLight.notice();
    }
}
