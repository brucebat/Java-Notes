package problem217;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * LeetCode 217: 存在重复元素
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/8/8 12:58 上午
 */
public class Solution {

    public static boolean containsDuplicate(int[] nums) {
        if (Objects.isNull(nums) || 2 > nums.length) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean check = containsDuplicate(new int[]{1, 2, 3, 4, 1});
        System.out.println(check);
    }
}
