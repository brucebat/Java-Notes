package problem20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode20: 有效的括号
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2021/4/3 10:31 下午
 */
public class Solution {

    /**
     * 进行有效括号检测
     *
     * @param s 待检查字符串
     * @return 返回是否通过检查
     */
    public boolean isValid(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<String, String> context = new HashMap<>(3);
        context.put("}", "{");
        context.put(")", "(");
        context.put("]", "[");
        // 对于有效括号的检测可以使用栈的方式进行判断
        Stack<String> stack = new Stack<>();
        String[] brackets = s.split("");
        for (String bracket : brackets) {
            // 根据给出的括号
            if (context.containsKey(bracket)) {
                if (!stack.empty() && stack.peek().equals(context.get(bracket))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(bracket);
        }
        return stack.empty();
    }

}
