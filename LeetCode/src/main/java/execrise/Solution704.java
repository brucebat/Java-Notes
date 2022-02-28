package execrise;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/2/26 8:16 PM
 */
public class Solution704 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(doSearch(0, nums.length - 1, nums, 9));
    }

    private static int doSearch(int low, int high, int[] nums, int target) {
        if (high <= low) {
            return -1;
        }
        int middle = (high + low) / 2;
        if (middle == low) {
            if (nums[high] == target) {
                return high;
            }
            if (nums[low] == target) {
                return low;
            }
            return -1;
        }
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return doSearch(low, middle, nums, target);
        } else {
            return doSearch(middle, high, nums, target);
        }
    }
}
