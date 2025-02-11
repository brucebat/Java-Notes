package twoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/2/5 02:12
 */
public class LongestSub {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int left = 0;
        int right = left + 1;
        Set<Character> temp = new HashSet<>();
        temp.add(s.charAt(left));
        int max = 0;
        while(right < s.length()) {
            if (temp.contains(s.charAt(right))) {
                max = Math.max(max, right - left);
                left++;
                right = left + 1;
                temp.clear();
                temp.add(s.charAt(left));
            } else {
                temp.add(s.charAt(right));
                right++;
            }
        }
        System.out.println(Math.max(max, right - left));
    }
}
