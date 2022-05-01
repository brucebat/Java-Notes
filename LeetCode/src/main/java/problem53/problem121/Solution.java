package problem53.problem121;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/23 22:36
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length ; i++) {
            for (int j = i + 1; j < prices.length; j ++) {
                int tempProfit = prices[j] - prices[i];
                if (tempProfit > profit) {
                    profit = tempProfit;
                }
            }
        }
        return profit;
    }



}
