package ObserverPattern.listener;

import ObserverPattern.event.CommonEvent;

import java.util.EventListener;

/**
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/24 11:07 下午
 */
public interface CommonListener extends EventListener {

    /**
     * 处理事件
     *
     * @param event 待处理事件
     */
    void handleEvent(CommonEvent event);
}
