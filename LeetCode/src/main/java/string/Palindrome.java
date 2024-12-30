package string;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/28 17:13
 */
public class Palindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        if(null == s || s.length() == 0) {
            System.out.println(false);
            return;
        }
        s = s.toLowerCase();
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                builder.append(s.charAt(i));
            }
        }
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) != builder.charAt(builder.length() - 1 - i)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
        return;
    }
}
