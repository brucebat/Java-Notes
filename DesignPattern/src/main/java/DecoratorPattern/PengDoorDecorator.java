package DecoratorPattern;

/**
 * 鹏翼门装饰器
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/5/23 10:56 下午
 */
public class PengDoorDecorator extends PengDecorator{

    public PengDoorDecorator(PengCar pengCar) {
        super(pengCar);
    }

    @Override
    void run() {
        super.run();
        System.out.println("增加鹏翼门！");
    }
}
