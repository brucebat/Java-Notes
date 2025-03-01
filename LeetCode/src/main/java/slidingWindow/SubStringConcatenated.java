package slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/2/13 23:55
 */
public class SubStringConcatenated {

    public static List<Integer> findSubstring(String s, String[] words) {
        // Sliding Window
        int windowLength = 0;
        for(String singleWord : words) {
            windowLength += singleWord.length();
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        while (left < s.length()) {
            int tempIndex = left;
            while(tempIndex < left + windowLength) {
                int notHit = 0;
                for(String singleWord : words) {
                    if(singleWord.startsWith(String.valueOf(s.charAt(tempIndex)))) {
                        if(singleWord.equals(s.substring(tempIndex, tempIndex + singleWord.length()))) {
                            tempIndex += singleWord.length();
                        } else {
                            break;
                        }
                    } else {
                        notHit++;
                    }
                }
                if (notHit == words.length) {
                    tempIndex++;
                    break;
                }
            }
            if (tempIndex == left + windowLength) {
                result.add(left);
            }
            left = tempIndex;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        System.out.println(findSubstring(s, new String[]{"foo","bar"}));
    }
}
