package problem42;

/**
 * 接雨水问题
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/28 23:25
 */
public class Solution {
    public int trap(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int j = 1; j < length - 1; j++) {
            leftMax[j] = Math.max(leftMax[j - 1], height[j]);
        }
        int sum = 0;
        for (int x = 0; x < length - 1; x++) {
            sum += Math.min(leftMax[x], rightMax[x]) - height[x];
        }
        return sum;
    }
}
