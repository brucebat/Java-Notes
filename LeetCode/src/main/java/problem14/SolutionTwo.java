package problem14;

import java.util.Objects;

/**
 * LeetCode 14：最长公共前缀
 *
 * @author suntianyu
 * @version 1.0
 * @since Created at 2021/3/3 9:25 下午
 */
public class SolutionTwo {

    /**
     * 根据给出的字符串数组判断最长公共前缀
     *
     * @param strs 待判断字符串数组
     * @return 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || 0 == strs.length) {
            return "";
        }
        String tempPrefix = strs[0];
        for (String str : strs) {

        }
        return "";
    }

    /**
     * 获取公共前缀
     *
     * @param source 来源字符串
     * @param target 目标字符串
     * @return 公共前缀
     */
    private String getCommonPrefix(String source, String target) {
        return "";
    }
}
