package ObserverPattern.listener;

import ObserverPattern.event.CommonEvent;

import java.util.EventListener;

/**
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/24 11:06 下午
 */
public class StudentListener implements CommonListener {

    @Override
    public void handleEvent(CommonEvent event) {
        event.action();
        // 进行事件处理
        System.out.println("开始处理" + event.getEventName() + "事件");
    }
}
