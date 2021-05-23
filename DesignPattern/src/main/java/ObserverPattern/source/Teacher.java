package ObserverPattern.source;

import ObserverPattern.event.CommonEvent;
import ObserverPattern.event.PlayEvent;
import ObserverPattern.event.StudyEvent;
import ObserverPattern.listener.CommonListener;
import lombok.Data;

import java.util.Vector;

/**
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/24 11:12 下午
 */
@Data
public class Teacher {

    private Vector<CommonListener> listeners;

    public Teacher() {
        listeners = new Vector<>();
    }

    public void addListener(CommonListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(CommonListener listener) {
        this.listeners.remove(listener);
    }

    /**
     * 发出学习指令
     */
    public void commandStudy() {
        this.notifyAllListeners(new StudyEvent(this));
    }

    /**
     * 发出玩耍指令
     */
    public void commandPlay() {
        this.notifyAllListeners(new PlayEvent(this));
    }

    /**
     * 通知所有监听者
     *
     * @param event 待处理事件
     */
    private void notifyAllListeners(CommonEvent event) {
        for (CommonListener listener : this.listeners) {
            listener.handleEvent(event);
        }
    }



}
