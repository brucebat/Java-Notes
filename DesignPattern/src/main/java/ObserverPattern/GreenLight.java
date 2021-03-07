package ObserverPattern;

import org.apache.commons.collections.CollectionUtils;

/**
 * 观察者模式具体观察目标--绿灯
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/7 10:18 下午
 */
public class GreenLight extends TrafficLight{

    @Override
    public void notice() {
        if (CollectionUtils.isEmpty(cars)) {
            return;
        }
        for (Car car : cars) {
            car.start();
        }
    }
}
