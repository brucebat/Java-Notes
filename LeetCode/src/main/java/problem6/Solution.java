package problem6;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/1 9:32 PM
 */
public class Solution {

    public String convert(String s, int numRows) {
        if (null == s || 0 == s.length()) {
            return null;
        }
        if (numRows >= s.length() || numRows == 1) {
            return s;
        }
        int t = 2 * (numRows - 1);
        // 这里计算的时候需要向上取整，否则会出现漏字符串的问题
        int xLength = (s.length() + t - 1) / t;
        xLength *= numRows - 1;
        // TODO 这里的列计算存在问题
        String[][] splitChars = new String[xLength + 1][numRows];
        int charSize = 0;
        for (int i = 0; i <= xLength; i++) {
            if (charSize == s.length()) {
                break;
            }
            if (i == 0 || i % (numRows - 1) == 0) {
                for (int j = 0; j < numRows; j++) {
                    if (charSize == s.length()) {
                        break;
                    }
                    splitChars[i][j] = String.valueOf(s.charAt(charSize));
                    charSize++;
                }
            } else {
                splitChars[i][numRows - 1 - i % (numRows - 1)] = String.valueOf(s.charAt(charSize));
                charSize++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < numRows; y++) {
            for (int x = 0; x <= xLength; x++) {
                if (splitChars[x][y] != null && splitChars[x][y].length() != 0) {
                    result.append(splitChars[x][y]);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("ABCDE", 4));
    }
}
