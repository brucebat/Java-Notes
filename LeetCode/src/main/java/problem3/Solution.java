package problem3;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/4 12:01 AM
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int length = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                length++;
                continue;
            }
            boolean flag = true;
            for (int j = start; j < i; j++) {
                if (s.charAt(i) == (s.charAt(j))) {
                    start = j + 1;
                    if (length > max) {
                        max = length;
                    }
                    length = i - j;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                length++;
            }
        }
        if (length > max) {
            max = length;
        }
        return max;
    }
}
