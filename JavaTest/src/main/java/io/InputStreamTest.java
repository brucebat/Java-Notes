package io;

import java.io.*;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/2/15 1:21 上午
 */
public class InputStreamTest {

    /**
     * 标准输入字节流使用
     */
    public static void standardInputStream() {
        // 创建一个输入流
        try (InputStream inputStream = new FileInputStream("/Users/suntianyu/Desktop/test.sh")) {
            // 将输入流中的第一个字节数据读取到缓冲区中
            int read = inputStream.read();
            // 如果read返回的值小于0，表示读取完毕
            while (read != -1) {
                // 对读取到的数据进行处理
                System.out.println((char) read);
                // 继续读取下一个字节
                read = inputStream.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试字节流数组读取
     */
    public static void testByteArrayInputStream() {
        String data = "测试";
        try (InputStream inputStream = new ByteArrayInputStream(data.getBytes())) {
            // 将输入流中的第一个字节数据读取到缓冲区中
            int read = inputStream.read();
            // 如果read返回的值小于0，表示读取完毕
            while (read != -1) {
                // 对读取到的数据进行处理
                System.out.print((char) read);
                // 继续读取下一个字节
                read = inputStream.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testCharArrayReader() {
        String text = "蝙蝠侠";
        // 创建一个字符输入流，这里使用try-with-resources来避免显示的关闭流
        try (Reader reader = new CharArrayReader(text.toCharArray())) {
            // 将字符输入流中的第一个字符读取到缓冲区中
            int read = reader.read();
            // 如果read返回的值小于0，表示读取完毕
            while (read != -1) {
                // 对读取到的数据进行处理
                System.out.print((char) read);
                // 继续读取下一个字符
                read = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFileReader() {
        // 创建一个字符输入流，这里使用try-with-resources来避免显示的关闭流
        try (Reader reader = new FileReader("/Users/suntianyu/Desktop/test.json")) {
            // 将字符输入流中的第一个字符读取到缓冲区中
            int read = reader.read();
            // 如果read返回的值小于0，表示读取完毕
            while (read != -1) {
                // 对读取到的数据进行处理
                System.out.print((char) read);
                // 继续读取下一个字符
                read = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 标准输出字节流使用
     */
    public static void standardOutPutStream() {
        // 测试文本
        String text = "测试";
        // 创建一个输出流
        try (OutputStream outputStream = new FileOutputStream("/Users/suntianyu/Desktop/test.json")) {
            // 将字符串转换为字节数组，并写入到输出流中
            outputStream.write(text.getBytes());
            // 进行输入流的后续操作
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFileWriter() {
        String text = "蝙蝠侠";
        // 创建一个字符输出流，这里使用try-with-resources来避免显示的关闭流
        try (Writer writer = new FileWriter("/Users/suntianyu/Desktop/test.json")) {
            // 将字符输入流中的第一个字符读取到缓冲区中
            writer.write(text);
            // 将缓冲区中的数据写入到输出流中
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testFileReader();
    }
}
