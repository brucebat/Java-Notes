package string;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/25 17:00
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "the sky is blue";
        if (null == s || s.length() == 0) {
            return;
        }
        StringBuilder result = new StringBuilder();
        int length = s.length();
        int fast, slow = length;
        for(int i = length - 1; i>=0; i--) {
            fast = i;
            if(s.charAt(i) == ' ' || i == 0) {
                String tmp = s.substring(fast, slow);
                if (!tmp.trim().equals("")) {
                    if(result.toString().equals("")) {
                        result.append(tmp.trim());
                    } else {
                        result.append(" ").append(tmp.trim());
                    }
                }
                slow = fast;
            }
        }
        System.out.println(result);
    }
}
