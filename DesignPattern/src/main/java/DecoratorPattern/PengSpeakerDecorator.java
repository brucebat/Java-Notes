package DecoratorPattern;

/**
 * 定制音响装饰器
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/5/23 10:57 下午
 */
public class PengSpeakerDecorator extends PengDecorator {

    public PengSpeakerDecorator(PengCar pengCar) {
        super(pengCar);
    }

    @Override
    void run() {
        super.run();
        System.out.println("增加定制音响！");
    }
}
