package greedy;

/**
 * 发糖问题，题目详情可以参考{@see <a href="https://leetcode.cn/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150">Candy</a>}
 *
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/16 11:17
 */
public class Candy {

    public int candy(int[] ratings) {
        int sum = 1;
        // 递增长度
        int incrLength = 1;
        // 递减长度
        int decrLength = 0;
        int pre = 1;
        // 因为需要使用常数空间来完成对于数据的处理，所以此时在进行遍历的时候需要同时完成对于求和的处理
        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                decrLength = 0;
                pre = ratings[i] == ratings[i-1] ? 1 : pre + 1;
                sum += pre;
                incrLength = pre;
            } else {
                decrLength++;
                if (decrLength == incrLength) {
                    // 如果递增序列和递减序列一致则需要额外加一;
                    decrLength++;
                }
                sum += decrLength;
                pre = 1;
            }
        }
        return sum;
    }
}
