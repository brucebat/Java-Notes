package problem14;

import java.util.Arrays;
import java.util.Objects;

/**
 * LeetCode:14 最长公共前缀
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/1 11:08 下午
 */
public class Solution {

    /**
     * 根据给出的字符串数组判断最长公共前缀
     *
     * @param strs 待判断字符串数组
     * @return 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }
        for (int i = 1; i <= strs[0].length(); i++) {
            String tmpPrefix = strs[0].substring(0, i);
            boolean checkLimit = false;
            for (String str : strs) {
                if (!str.startsWith(tmpPrefix)) {
                    return tmpPrefix.length() == 1 ? "" : tmpPrefix.substring(0, tmpPrefix.length() - 1);
                }
                if (tmpPrefix.length() == str.length()) {
                    checkLimit = true;
                }
            }
            if (checkLimit) {
                return tmpPrefix;
            }
        }
        return "";
    }
}
