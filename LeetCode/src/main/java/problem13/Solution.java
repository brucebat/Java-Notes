package problem13;

import java.util.*;

/**
 * LeetCode13.罗马数字转整数
 *
 * @author Sun Tianyu
 * @version 1.0
 * @since Created in 2020/10/13
 */
public class Solution {

    private static final Map<String, Integer> BASIC_ROMAN_DIC = new HashMap<String, Integer>();

    static {
        BASIC_ROMAN_DIC.put("I", 1);
        BASIC_ROMAN_DIC.put("V", 5);
        BASIC_ROMAN_DIC.put("X", 10);
        BASIC_ROMAN_DIC.put("L", 50);
        BASIC_ROMAN_DIC.put("C", 100);
        BASIC_ROMAN_DIC.put("D", 500);
        BASIC_ROMAN_DIC.put("M", 1000);
        BASIC_ROMAN_DIC.put("IV", 4);
        BASIC_ROMAN_DIC.put("IX", 9);
        BASIC_ROMAN_DIC.put("XL", 40);
        BASIC_ROMAN_DIC.put("XC", 90);
        BASIC_ROMAN_DIC.put("CD", 400);
        BASIC_ROMAN_DIC.put("CM", 900);

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
            if (BASIC_ROMAN_DIC.containsKey(current + next)) {
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
            sum += BASIC_ROMAN_DIC.get(romanNumber);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
