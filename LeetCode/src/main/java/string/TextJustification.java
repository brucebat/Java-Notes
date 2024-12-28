package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/27 18:39
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        int left = 0, right = 0;
        int temp = 0;
        List<String> result = new ArrayList<>();
        while(right < words.length) {
            if(words[right].length() + temp + right - left <= maxWidth) {
                temp = temp + words[right].length();
                // 这里需要进行判断
                if (right == words.length - 1) {
                    right++;
                    StringBuilder part = handle(right, left, maxWidth, temp, words);
                    result.add(part.toString());
                    break;
                }
                right++;
            } else {
                // 前一个right值是可以纳入到计算当中
                // 计算每个空格需要填充多少个空格
                StringBuilder part = handle(right, left, maxWidth, temp, words);
                result.add(part.toString());
                left = right;
                temp = 0;
            }
        }
        System.out.println(result);
    }

    private static StringBuilder handle(int right, int left, int maxWidth, int temp, String[] words) {
        // 前一个right值是可以纳入到计算当中
        // 计算每个空格需要填充多少个空格
        StringBuilder part = new StringBuilder();
        int interval  = right - left - 1 > 0 ? right - left - 1 : 1;
        int baseSpaces = (maxWidth - temp) / interval;
        int leftSpaces = (maxWidth - temp) % interval;
        for(int i = left; i < right; i++) {
            // 进行实际的填充逻辑
            part.append(words[i]);
            int limit = leftSpaces > 0 ? baseSpaces + 1 : baseSpaces;
            // 这里最后一行的判断条件非常恶心，吐了
            if (right == words.length && temp > words[left].length()) {
                limit = 1;
            }
            if (leftSpaces > 0) {
                leftSpaces--;
            }
            if (i != right - 1 || i == left) {
                for(int j = 0; j < limit; j++) {
                    part.append(" ");
                }
            }
            else {
                if (right == words.length && i == right - 1) {
                    for (int j = 0; j < maxWidth - temp - interval; j++) {
                        part.append(" ");
                    }
                }
            }
        }
        return part;
    }
}
