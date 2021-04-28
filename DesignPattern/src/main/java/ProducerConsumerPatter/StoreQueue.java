package ProducerConsumerPatter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 缓冲队列
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/4/28 7:35 下午
 */
public class StoreQueue<T> {

    private final BlockingQueue<T> queue = new LinkedBlockingQueue<>();

    /**
     * 队列中增加数据
     *
     * @param data 生产者生产的数据
     */
    public void add(T data) {
        try {
            queue.put(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 队列中获取数据
     *
     * @return 从队列中获取到的数据
     */
    public T get() {
        try {
            return queue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
