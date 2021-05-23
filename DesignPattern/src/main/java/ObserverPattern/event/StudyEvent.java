package ObserverPattern.event;


import lombok.Getter;
import lombok.Setter;

/**
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/24 11:04 下午
 */
@Setter
@Getter
public class StudyEvent extends CommonEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public StudyEvent(Object source) {
        super(source);
        this.eventName = "学习事件";
    }

    @Override
    public void action() {
        study();
    }

    /**
     * 学习
     */
    public void study() {
        System.out.println("这是一个学习事件");
    }
}
