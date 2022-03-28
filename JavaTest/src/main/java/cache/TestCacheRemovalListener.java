package cache;

import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * 测试缓存移除监听器，当前测试逻辑为当前缓存并未失效而是缓存值发生变更的事件处理
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/28 3:24 PM
 */
public class TestCacheRemovalListener implements RemovalListener<String, String> {

    @Override
    public void onRemoval(RemovalNotification<String, String> notification) {
        if (RemovalCause.REPLACED.equals(notification.getCause())) {
            String key = notification.getKey();
            String value = notification.getValue();
            System.out.println("接收到缓存修改通知请求， key = " + key + ", value = " + value);
        }
    }
}
