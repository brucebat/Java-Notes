package ObserverPattern.event;

import lombok.Getter;
import lombok.Setter;

/**
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/24 11:03 下午
 */
@Setter
@Getter
public class PlayEvent extends CommonEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public PlayEvent(Object source) {
        super(source);
        this.eventName = "玩耍事件";
    }

    @Override
    public void action() {
        play();
    }

    /**
     * 玩耍
     */
    public void play() {
        System.out.println("这一个玩耍的事件");
    }
}
