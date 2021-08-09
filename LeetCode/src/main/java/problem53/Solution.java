package problem53;

import java.util.Objects;

/**
 * LeetCode 53: 最大子序和
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/8/8 9:24 下午
 */
public class Solution {

    /**
     * 根据输入参数获取具有最大和的子数组，返回其最大和.
     *
     * @param nums 待处理数组
     * @return 子数组的最大和
     */
    public static int maxSubArray(int[] nums) {
        if (Objects.isNull(nums)) {
            return -1;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        int maxSubSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tempSum = nums[i];
            int innerSubSum = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                innerSubSum += nums[j];
                if (innerSubSum > tempSum) {
                    tempSum = innerSubSum;
                }
            }
            if (tempSum > maxSubSum) {
                maxSubSum = tempSum;
            }
        }
        return maxSubSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,-1}));
    }
}
