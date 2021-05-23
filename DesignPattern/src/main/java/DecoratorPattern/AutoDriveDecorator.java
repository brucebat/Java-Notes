package DecoratorPattern;

/**
 * 自动驾驶装饰器
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/5/23 10:54 下午
 */
public class AutoDriveDecorator extends PengDecorator {

    public AutoDriveDecorator(PengCar pengCar) {
        super(pengCar);
    }

    @Override
    void run() {
        super.run();
        System.out.println("增加自动驾驶!");
    }
}
