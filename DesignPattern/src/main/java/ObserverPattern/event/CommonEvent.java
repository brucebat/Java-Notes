package ObserverPattern.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.EventObject;

/**
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/24 11:08 下午
 */
@Setter
@Getter
public abstract class CommonEvent extends EventObject {

    protected String eventName;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CommonEvent(Object source) {
        super(source);
    }

    /**
     * 进行操作
     */
    public abstract void action();
}
