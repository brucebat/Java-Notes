package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * 缓冲流处理测试
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/1/12 11:32 上午
 */
public class BufferedInputStreamTest {

    public static void main(String[] args) {
        // 进行缓冲流测试
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users/suntianyu/Desktop/test.sh"));
            StringBuilder combineText = new StringBuilder();
            int content = 0;
            while ((content = bufferedInputStream.read()) != -1) {
                combineText.append((char) content);
            }
            System.out.println(combineText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
