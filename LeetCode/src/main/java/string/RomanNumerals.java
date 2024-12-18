package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/17 12:50
 */
public class RomanNumerals {

    public static void main(String[] args) {
        String s = "1222";
        Map<String, Integer> table = new HashMap<>();
        table.put("I", 1);
        table.put("V", 5);
        table.put("X", 10);
        table.put("L", 50);
        table.put("C", 100);
        table.put("D", 500);
        table.put("M", 1000);

        String[] string = s.split("");
        int sum = table.get(string[0]);
        int index = 1;
        while(index < string.length) {
            if(table.get(string[index]) > table.get(string[index - 1])) {
                sum = sum + table.get(string[index]) - table.get(string[index - 1]) * 2;
            } else {
                sum += table.get(string[index]);
            }
            index++;
        }
        System.out.println(sum);
    }
}
