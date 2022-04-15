package problem3;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/4 12:03 AM
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        StringBuilder[] result = new StringBuilder[s.length()];
        for (int x = 0; x < s.length(); x++) {
            result[x] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (result[i].toString().contains(String.valueOf(s.charAt(j)))) {
                    break;
                }
                result[i].append(s.charAt(j));
            }
        }
        int max = 0;
        for (StringBuilder string : result) {
            if (string.length() > max) {
                max = string.length();
            }
        }
        return max;
    }
}
