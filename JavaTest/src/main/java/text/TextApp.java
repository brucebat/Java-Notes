package text;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/2/11 5:16 下午
 */
public class TextApp {

    public static void main(String[] args) {
        String originalText = "AssBc\n";
        String regex = "[A-Za-z]";
        System.out.println("原始文本正则匹配结果: " + originalText.matches(regex));
        String[] texts = originalText.split("");
        for (String text : texts) {
            System.out.println("单个字符正则匹配结果: " + text.matches(regex));
        }
    }
}
