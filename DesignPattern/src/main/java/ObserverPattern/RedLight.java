package ObserverPattern;

import org.apache.commons.collections.CollectionUtils;

/**
 * 观察者模式具体观察目标--红灯
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/7 10:17 下午
 */
public class RedLight extends AbstractTrafficLight {

    @Override
    public void notice() {
        if (CollectionUtils.isEmpty(cars)) {
            return;
        }
        for (Car car : cars) {
            car.stop();
        }
    }
}
