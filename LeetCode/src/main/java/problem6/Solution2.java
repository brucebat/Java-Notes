package problem6;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/3 11:40 PM
 */
public class Solution2 {

    public String convert(String s, int numRows) {
        if (null == s || 0 == s.length()) {
            return null;
        }
        int length = s.length();
        if (1 == numRows || numRows >= length) {
            return s;
        }
        StringBuilder[] lineText = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            lineText[i] = new StringBuilder();
        }
        for (int j = 0, x = 0, t = numRows * 2 - 2; j < length; j++) {
            lineText[x].append(s.charAt(j));
            if (j % t < numRows - 1) {
                x++;
            } else {
                x--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : lineText) {
            result.append(stringBuilder);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("ABCDE", 4));
    }
}
