package problem13;

import java.util.*;

/**
 * LeetCode13.罗马数字转整数
 *
 * @author Sun Tianyu
 * @version 1.0
 * @date Created in 2020/10/13
 */
public class Solution {

    private static final Map<String, Integer> basicRomanDic = new HashMap<String, Integer>();

    static {
        basicRomanDic.put("I", 1);
        basicRomanDic.put("V", 5);
        basicRomanDic.put("X", 10);
        basicRomanDic.put("L", 50);
        basicRomanDic.put("C", 100);
        basicRomanDic.put("D", 500);
        basicRomanDic.put("M", 1000);
        basicRomanDic.put("IV", 4);
        basicRomanDic.put("IX", 9);
        basicRomanDic.put("XL", 40);
        basicRomanDic.put("XC", 90);
        basicRomanDic.put("CD", 400);
        basicRomanDic.put("CM", 900);

    }

    /**
     * 进行罗马数字转换成整数
     *
     * @param s 待转换罗马数字
     * @return 整数
     */
    public int romanToInt(String s) {
        List<String> romanNumbers = splitRomanNumber(s);
        return sum(romanNumbers);
    }

    /**
     * 进行罗马数据拆分
     *
     * @param romanNumber 罗马数字
     * @return 返回拆分好的罗马数字
     */
    private List<String> splitRomanNumber(String romanNumber) {
        if (null == romanNumber || 0 == romanNumber.length()) {
            return Collections.emptyList();
        }
        String[] numbers = romanNumber.split("");
        List<String> targetNumbers = new ArrayList<String>();
        for (int i = 0; i < numbers.length; i++) {
            String current = numbers[i];
            String next = "";
            if (i < numbers.length - 1) {
                next = numbers[i + 1];
            }
            if (basicRomanDic.containsKey(current + next)) {
                targetNumbers.add(current + next);
                i ++ ;
            } else {
                targetNumbers.add(current);
            }
        }
        return targetNumbers;
    }

    /**
     * 进行求和操作
     *
     * @param romanNumbers 待求和罗马数字列表
     * @return 返回结果
     */
    private int sum(List<String> romanNumbers) {
        int sum = 0;
        if (0 == romanNumbers.size()) {
            return sum;
        }
        for (String romanNumber : romanNumbers) {
            sum += basicRomanDic.get(romanNumber);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
