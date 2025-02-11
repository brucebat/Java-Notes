package twoPointers;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/1/28 17:52
 */
public class MinimumSubarray {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = left + 1;
        int sum = nums[left];
        int minCount = 0;
        int tempCount = 1;
        // 这里的判断条件是有点问题的
        while(right < nums.length || sum >= target) {
            if (sum >= target) {
                left++;
                right = left + 1;
                // 这里需要注意minCount初始值是0
                minCount = Math.min(minCount, tempCount);
                if (minCount == 0) {
                    minCount = tempCount;
                }
                if (left == nums.length) {
                    break;
                }
                sum = nums[left];
                tempCount = 1;
            } else {
                sum = sum + nums[right];
                tempCount++;
                // 这个位置有点问题，需要对于边界值进行重新确定
                right++;
            }
        }
        return minCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(15, nums));

    }
}
