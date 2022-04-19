package sorted;

import java.util.Random;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/18 7:39 PM
 */
public class QuickSortUtils {

    public static void sort(int[] nums, int start, int end) {
        if (start < end) {
            // 基准数据
            int base = nums[start];
            // 临时变量
            int temp;
            // 双指针
            int i = start, j = end;
            do {
                // 使用双指针分别从数组的两头进行遍历啊
                while (nums[i] < base && i < end) {
                    i++;
                }
                while (nums[j] > base && j > start) {
                    j--;
                }
                // 这里进行区间的数据交换
                if (i <= j) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                sort(nums, start, j);
            }
            if (end > i) {
                sort(nums, i, end);
            }
        }
    }

    Random random = new Random();

    /**
     * 进行随机快速排序, 采用随机的基准数据进行处理，基准数据左边为小于它的数据，右边为大于它的数据
     *
     * @param nums
     * @param l
     * @param r
     */
    public void randomSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = partition(nums, l, r);
        randomSort(nums, l, q - 1);
        randomSort(nums, q + 1, r);
    }

    private int partition(int[] a, int l, int r) {
        swap(a, l, random.nextInt(r - l + 1) + l);
        int base = a[l], i = l;
        for (int j = l + 1; j <= r; j++) {
            if (a[j] < base) {
                i++;
                swap(a, j, i);
            }
        }
        swap(a, l, i);
        return i;

    }

    public void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 5, 6, 4};
        QuickSortUtils q = new QuickSortUtils();
        q.randomSort(a, 0, 5);
        System.out.println(a);
    }
}
