package ProxyPattern;

/**
 * 商品代理类
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/7/25 2:04 上午
 */
public class ShopProxy extends AbstractShop {

    private final ConcreteShop concreteShop;

    public ShopProxy() {
        this.concreteShop = new ConcreteShop();
    }

    public void preBuy(String commodityName) {
        boolean checkEnough = concreteShop.checkEnough(commodityName);
        if (checkEnough) {
            System.out.println("当前商品货源充足可以购买");
            return;
        }
        throw new NullPointerException("当前商品处于缺货状态");
    }

    @Override
    public void buy(String commodityName) {
        this.preBuy(commodityName);
        concreteShop.buy(commodityName);
        this.afterBuy();
    }

    public void afterBuy() {
        System.out.println("完成购买，开始发货");
    }
}
