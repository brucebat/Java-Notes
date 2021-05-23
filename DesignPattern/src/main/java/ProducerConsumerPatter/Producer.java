package ProducerConsumerPatter;

/**
 * 生产者
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/4/27 7:21 下午
 */
public class Producer implements Runnable{

    private StoreQueue<String> storeQueue;

    public Producer(StoreQueue<String> storeQueue) {
        this.storeQueue = storeQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storeQueue.add(Thread.currentThread().getName() + ":" + i);
        }
    }
}
