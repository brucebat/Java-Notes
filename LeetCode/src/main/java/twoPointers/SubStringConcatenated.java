package twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 30
 * 本题需要使用异构词的思路来进行问题的求解
 *
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/3/12 16:32
 */
public class SubStringConcatenated {
    public static void main(String[] args) {
        Map<String, Integer> temp = new HashMap<>();
        SubStringConcatenated subStringConcatenated = new SubStringConcatenated();
        String s = "barfoothefoobarman";
        System.out.println(s.substring(17));
        String[] words = new String[]{"foo","bar"};
        System.out.println(subStringConcatenated.findSubstring(s, words));
    }

    /**
     * 需要使用异构词方法中的频次来判断是否符合需求
     *
     * @param s 目标字符串
     * @param words 带判断字符串数组
     * @return 最终结果
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int m = words.length, n = words[0].length(), ls = s.length();
        // 这里需要理解清楚的是为什么最外部的循环是按照一个单词长度进行循环的
        // 这是为了避免重复
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            // 进行滑动窗口的移动，每次移动一个单词的长度
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

}
