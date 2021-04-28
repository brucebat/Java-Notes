package ProducerConsumerPatter;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/4/28 7:48 下午
 */
public class App {

    public static void main(String[] args) {
        StoreQueue<String> storeQueue = new StoreQueue<>();
        Producer producer = new Producer(storeQueue);
        Consumer consumer = new Consumer(storeQueue);
        Producer producerTwo = new Producer(storeQueue);
        Consumer consumerTwo = new Consumer(storeQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(producerTwo).start();
        new Thread(consumerTwo).start();
    }
}
