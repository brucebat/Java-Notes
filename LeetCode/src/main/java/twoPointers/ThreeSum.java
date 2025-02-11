package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/1/25 14:18
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 将问题从三数之和转换成两数之和
        if (null == nums || nums.length  < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left  < right) {
                int sum = nums[left] + nums[right];
                if (sum == - nums[i]) {
                    // 去重的逻辑需要仔细思考一下，这个点实际上就是影响时间的关键节点
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                } else if (sum > - nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(threeSum(nums));

    }
}
