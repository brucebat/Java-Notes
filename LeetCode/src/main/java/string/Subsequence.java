package string;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/29 19:38
 */
public class Subsequence {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        if (null == s || null == t || s.length() > t.length()) {
            System.out.println(false);
            return;
        }
        if (s.length() == 0) {
            System.out.println(true);
            return;
        }
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                System.out.println(true);
                return;
            } else {
                System.out.println(false);
                return;
            }
        }
        int shortter = s.length();
        int longger = t.length();
        int index = 0;
        for(int i = 0; i < shortter; i++) {
            if (index == longger - 1) {
                System.out.println(false);
                return;
            }
            char tempI = s.charAt(i);
            for(int j = index; j < longger; j++) {
                char tempJ = t.charAt(j);
                if (tempJ == tempI) {
                    // 两者相等的情况下
                    index = j + 1;
                    break;
                } else {
                    if (j == longger - 1) {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        System.out.println(true);
        int a = 1;
        int b = 2;
        int[] c = {a, b};
        return;
    }
}
