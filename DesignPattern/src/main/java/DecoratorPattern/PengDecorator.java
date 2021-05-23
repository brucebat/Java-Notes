package DecoratorPattern;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/5/23 10:52 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class PengDecorator extends PengCar{

    private PengCar pengCar;

    public PengDecorator(PengCar pengCar) {
        this.pengCar = pengCar;
    }

    @Override
    void run() {
        pengCar.run();
    }
}
