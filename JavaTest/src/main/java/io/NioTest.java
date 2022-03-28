package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * NIO测试类——
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/9 4:19 PM
 */
public class NioTest {

    private static final int COUNT_LIMIT = 10;

    /**
     * 进行NIO文件写入测试
     */
    public static void testFileWrite() {
        try {
            RandomAccessFile file = new RandomAccessFile("/Users/suntianyu/Desktop/test.txt", "rw");
            FileChannel fileChannel = file.getChannel();
            doWrite(fileChannel);
//            doRead(fileChannel);
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 进行实际写入操作
     *
     * @param fileChannel 待写入文件通道
     * @throws IOException IO异常
     */
    private static void doWrite(FileChannel fileChannel) throws IOException {
        String data = "This is a test.";
        ByteBuffer buffer = ByteBuffer.allocate(data.getBytes().length);
        // 进行buffer放置前的清除操作
        buffer.clear();
        buffer.put(data.getBytes());
        // 进行写入准备
        buffer.flip();
        while (buffer.hasRemaining()) {
            fileChannel.write(buffer);
        }
    }

    /**
     * 进行读取操作
     */
    public static void testFileRead() {
        try {
            RandomAccessFile file = new RandomAccessFile("/Users/suntianyu/Desktop/test.txt", "rw");
            FileChannel fileChannel = file.getChannel();
            doRead(fileChannel);
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 进行读取操作
     *
     * @param fileChannel  待读取channel
     * @throws IOException IO异常
     */
    private static void doRead(FileChannel fileChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(40);
        int byteRead = fileChannel.read(buffer);
        while (byteRead != -1) {
            System.out.println("Read: " + byteRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            byteRead = fileChannel.read(buffer);
        }
    }

    /**
     * 进行网络通信测试——接收
     *
     * @throws IOException IO异常
     */
    public static void testReceiveSocketCommunication() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 进行服务端口地址绑定操作
        serverSocketChannel.bind(new InetSocketAddress("http://localhost", 8090));
        int count = 0;
        while (count < COUNT_LIMIT) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer readBuffer = ByteBuffer.allocate(40);
            socketChannel.read(readBuffer);
            if (readBuffer.array().length > 0) {
                System.out.println(Arrays.toString(readBuffer.array()));
            }
            count++;
        }
    }

    /**
     * 进行网络通信测试——发送
     *
     * @throws IOException IO异常
     */
    public static void testSendSocketCommunication() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("http://localhost", 8090));
        ByteBuffer writeBuffer = ByteBuffer.allocate(40);
        writeBuffer.clear();
        writeBuffer.put("This is a test.".getBytes());
        writeBuffer.flip();
        while (writeBuffer.hasRemaining()) {
            socketChannel.write(writeBuffer);
        }
    }

    public static void main(String[] args) throws IOException {
        // 进行文件读取测试
        testFileWrite();
        testFileRead();
    }
}
