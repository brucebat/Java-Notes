package dynamicProgramming;

/**
 * LeetCode5: 最长回文子串
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/28 12:12 AM
 */
public class Problem5 {

    public static String longestPalindrome(String s) {
        String[] dp = new String[s.length()];
        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            int lastIndex = s.lastIndexOf(character);
            String tempText = s.substring(i, lastIndex + 1);
            while (!checkBackText(tempText)) {
                tempText = tempText.substring(0, tempText.length() - 1);
                lastIndex = tempText.lastIndexOf(character);
                tempText = tempText.substring(0, lastIndex + 1);
            }
            dp[i] = tempText;
            if (tempText.length() == s.length()) {
                return tempText;
            }
            if (tempText.length() > maxLength) {
                maxLength = tempText.length();
                maxIndex = i;
            }
        }
        return dp[maxIndex];
    }


    private static boolean checkBackText(String text) {
        int textLength = text.length();
        for (int i = 0; i < textLength / 2; i++) {
            if (text.charAt(i) != text.charAt(textLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(checkBackText("aba"));
        System.out.println(longestPalindrome("xaabacxcabaaxcabaax"));
    }
}
