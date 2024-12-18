package dynamicProgramming;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/16 11:31
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = 0;
        for(int i = 1; i < height.length; i++) {
            if(height[i] > height[i-1]) {
                if (i == height.length - 1 || height[i] > height[i + 1]) {
                    right = i;
                    int top = Math.min(height[left], height[right]);
                    for (int j = left + 1; j < right; j++) {
                        sum = sum + top - height[j];
                    }
                    left = i;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(new TrappingRainWater().trap(height));
    }

}
