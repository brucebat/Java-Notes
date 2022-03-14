package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO测试类——
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/9 4:19 PM
 */
public class NioTest {

    /**
     * 进行NIO文件写入测试
     */
    public static void testFileWrite() {
        try {
            RandomAccessFile file = new RandomAccessFile("/Users/suntianyu/Desktop/test.txt", "rw");
            FileChannel fileChannel = file.getChannel();
            String data = "This is a test.";
            ByteBuffer buffer = ByteBuffer.allocate(40);
            // 进行buffer放置前的清除操作
            buffer.clear();
            buffer.put(data.getBytes());
            // 进行写入准备
            buffer.flip();
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 进行网络通信测试
     */
    public static void testSocketCommunication() {

    }

    public static void main(String[] args) throws IOException {
        testFileWrite();
    }
}
