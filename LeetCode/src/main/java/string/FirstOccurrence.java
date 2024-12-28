package string;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/26 20:11
 */
public class FirstOccurrence {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        if (null == haystack || null == needle || needle.length() == 0 || haystack.length() < needle.length()) {
            System.out.println(-1);
            return;
        }
        int index = 0;
        while(index < haystack.length()) {
            for(int i = 0; i < needle.length(); i++) {
                if(haystack.charAt(index + i) != needle.charAt(i)) {
                    index = index + i;
                    break;
                }
                if(i == needle.length() - 1) {
                    System.out.println(index);
                    return;
                }
            }
            index++;
        }
        System.out.println(-1);
        return;
    }
}
