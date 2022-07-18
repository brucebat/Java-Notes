package problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/20 7:01 PM
 */
public class Solution {
    Random random = new Random();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] >= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int first = 0; first < n; ++first) {
            // 去重操作
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; ++second) {
                // 去重操作
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[first]);
                    tuple.add(nums[second]);
                    tuple.add(nums[third]);
                    result.add(tuple);
                }
            }
        }
        return result;
    }


    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = partition(nums, l, r);
        quickSort(nums, l, q - 1);
        quickSort(nums, q + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        swap(nums, l, random.nextInt(r - l + 1) + l);
        int base = nums[l], i = l;
        for (int j = l + 1; j < r; j++) {
            if (nums[j] < base) {
                i++;
                swap(nums, i, j);
            }
        }
        // 进行基元地址交换
        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
