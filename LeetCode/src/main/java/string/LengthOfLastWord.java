package string;

/**
 * Length Of Last Word
 * @see <a href="https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150">Length Of Last Word</a>
 * 最佳解题思路：反向遍历，从尾部来找对应的单词。
 *
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/20 09:47
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int index = 0;
        int result = 0;
        String[] strings = s.split("");
        while(index < s.length()) {
            if(!strings[index].equals(" ")) {
                if (index > 1 && strings[index - 1].equals(" ")) {
                    result = 0;
                }
                result++;
            }
            index++;
        }
        System.out.println(result);
    }
}
