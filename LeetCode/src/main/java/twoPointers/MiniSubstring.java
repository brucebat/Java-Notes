package twoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/3/13 14:58
 */
public class MiniSubstring {

    public static void main(String[] args) {
        MiniSubstring miniSubstring = new MiniSubstring();
        System.out.println(miniSubstring.minWindowTwo("ab", "a"));
    }

    public String minWindow(String s, String t) {
        // 滑动窗口
        int wL = t.length();
        int sL = s.length();
        if (sL < wL) {
            return "";
        }
        while(wL <= sL) {
            for(int i = 0; i < wL; i++) {
                for(int j = i; j < sL - wL + 1; j+=wL) {
                    Map<String, Integer> differ = new HashMap<>();

                    for(int k = 0; k < t.length(); k++) {
                        differ.put(t.substring(k, k+1), differ.getOrDefault(t.substring(k, k+1), 0) + 1);
                    }
                    for(int m = j; m < j + wL; m++) {
                        String letter = s.substring(m, m+1);
                        if (!differ.containsKey(letter)) {
                            continue;
                        }
                        differ.put(letter, differ.get(letter) - 1);
                        if (differ.get(letter) == 0) {
                            differ.remove(letter);
                        }
                    }
                    if (differ.isEmpty()) {
                        return s.substring(j, j+wL);
                    }
                }
            }
            wL++;
        }
        return "";
    }


    public String minWindowTwo(String s, String t) {
        // 滑动窗口
        int left = 0;
        int right = 0;
        if (null == s || null == t || s.length() == 0 || t.length() == 0) {
            return "";
        }
        String minWindow = s;
        int minWL = Integer.MAX_VALUE;
        Map<String, Integer> differ = new HashMap<>();
        for(int k = 0; k < t.length(); k++) {
            differ.put(t.substring(k, k+1), differ.getOrDefault(t.substring(k, k+1), 0) + 1);
        }
        boolean contains = false;
        while(right < s.length()) {
            // 右指针扩展
            while(right < s.length()) {
                String letter = s.substring(right, right + 1);
                if(differ.containsKey(letter)) {
                    differ.put(letter, differ.get(letter) - 1);
                }
                right++;
                // 这里需要判断是否所有的元素对应的次数都是小于0的，如果小于0则跳出
                boolean judge = differ.values().stream().anyMatch(p -> p > 0);
                if(!judge) {
                    if (minWL > right - left) {
                        minWindow = s.substring(left, right);
                        minWL = right - left;
                        contains = true;
                    }
                    break;
                }
            }
            // 左指针缩减
            while(left < right) {
                String letter = s.substring(left, left + 1);
                if(differ.containsKey(letter)) {
                    differ.put(letter, differ.get(letter) + 1);
                }
                left++;
                boolean judge = differ.values().stream().anyMatch(p -> p > 0);
                if(judge) {
                    if(right - left + 1 < minWL) {
                        minWindow = s.substring(left - 1, right);
                        minWL = right - left + 1;
                    }
                    break;
                }
            }
        }
        return contains ? minWindow :  "";
    }
}
