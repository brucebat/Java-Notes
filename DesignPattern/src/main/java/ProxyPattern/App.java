package ProxyPattern;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/7/25 2:09 上午
 */
public class App {

    public static void main(String[] args) {
        AbstractShop abstractShop = new ShopProxy();
        abstractShop.buy("皮带");
    }
}
