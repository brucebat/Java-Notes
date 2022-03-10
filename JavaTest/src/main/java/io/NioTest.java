package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/9 4:19 PM
 */
public class NioTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/suntianyu/Desktop/test.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        String data = "This is a test.";
        ByteBuffer buffer = ByteBuffer.allocate(40);
        buffer.clear();
        buffer.put(data.getBytes());
        while (buffer.hasRemaining()) {
            fileChannel.write(buffer);
        }
        fileChannel.close();
    }
}
