package twoPointers;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/30 11:04
 */
public class TwoSumII {

    public static void main(String[] args) {
        // 当前解法耗时过长，需要使用下面这个解法
        int[] numbers = {-10,-8,-2,1,2,5,6};
        int target = 0;
        for(int i = numbers.length - 1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] + numbers[j] == target) {
                    System.out.println(new int[]{j + 1, i + 1});
                    return;
                }
            }
        }
        return;
    }

    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
