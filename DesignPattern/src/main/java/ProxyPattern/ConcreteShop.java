package ProxyPattern;

/**
 * 实际商店类
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/7/25 2:00 上午
 */
public class ConcreteShop extends AbstractShop {

    /**
     * 根据商品名称进行数量是否足够检查
     *
     * @param commodityName 商品名称
     * @return 商品数量是否足够
     */
    public boolean checkEnough(String commodityName) {
        return "皮带".equals(commodityName);
    }

    @Override
    public void buy(String commodityName) {
        System.out.println("购买" + commodityName + "完成");
    }
}
