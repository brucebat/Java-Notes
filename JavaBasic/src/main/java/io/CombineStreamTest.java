package io;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;

/**
 * 组合流使用案例
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/1/9 11:13 下午
 */
public class CombineStreamTest {

    public static void main(String[] args) {
        InputStream inputStreamOne = new ByteArrayInputStream("This is a test.".getBytes());
        InputStream inputStreamTwo;
        try {
            inputStreamTwo = new FileInputStream("/Users/suntianyu/Desktop/test.sh");
            SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreamTwo, inputStreamOne);
            StringBuilder combineText = new StringBuilder();
            int n;
            while ((n = sequenceInputStream.read()) != -1) {
                combineText.append((char) n);
            }
            System.out.println(combineText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
