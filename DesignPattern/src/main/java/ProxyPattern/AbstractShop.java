package ProxyPattern;

/**
 * 抽象商场类
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/7/25 1:56 上午
 */
public abstract class AbstractShop {

    /**
     * 购买
     *
     * @param commodityName 商品名称
     */
    public abstract void buy(String commodityName);
}
