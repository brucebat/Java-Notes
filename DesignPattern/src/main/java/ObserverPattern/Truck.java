package ObserverPattern;

/**
 * 观察者模式具体观察者--货车
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/7 10:20 下午
 */
public class Truck implements Car{
    @Override
    public void start() {
        System.out.println("Truck start!");
    }

    @Override
    public void stop() {
        System.out.println("Truck stop!");
    }
}
