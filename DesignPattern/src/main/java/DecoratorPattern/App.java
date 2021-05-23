package DecoratorPattern;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/5/23 10:59 下午
 */
public class App {

    public static void main(String[] args) {
        // 以小鹏P5为例
        PengFiveCar pengFiveCar = new PengFiveCar();
        AutoDriveDecorator autoDriveDecorator = new AutoDriveDecorator(pengFiveCar);
        PengDoorDecorator pengDoorDecorator = new PengDoorDecorator(autoDriveDecorator);
        PengSpeakerDecorator pengSpeakerDecorator = new PengSpeakerDecorator(pengDoorDecorator);
        pengSpeakerDecorator.run();
    }
}
