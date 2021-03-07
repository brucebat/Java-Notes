package ObserverPattern;

/**
 * 观察者模式具体观察者--自行车
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/7 10:21 下午
 */
public class Bicycle implements Car{
    @Override
    public void start() {
        System.out.println("Bicycle start!");
    }

    @Override
    public void stop() {
        System.out.println("Bicycle stop!");
    }
}
