package ProducerConsumerPatter;

/**
 * 消费者
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/4/27 7:23 下午
 */
public class Consumer implements Runnable{

    private StoreQueue<String> storeQueue;

    public Consumer(StoreQueue<String> storeQueue) {
        this.storeQueue = storeQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String data = storeQueue.get();
                System.out.println("当前消费线程 : " + Thread.currentThread().getName() + ", 接收到数据 : " + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
