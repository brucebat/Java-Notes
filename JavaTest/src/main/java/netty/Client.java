package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * netty服务测试类--客户端
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/7/4 00:07
 */
public class Client {

    /**
     * 服务端地址
     */
    private String serverHost;
    /**
     * 服务端端口号
     */
    private Integer serverPort;

    public static void main(String[] args) {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    ctx.writeAndFlush(Unpooled.copiedBuffer("这是一个测试, 这是从客户端发送来的消息", CharsetUtil.UTF_8));
                                }

                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    if (msg instanceof ByteBuf) {
                                        ByteBuf byteBuf = (ByteBuf) msg;
                                        System.out.println("收到服务端 [" + ctx.channel().remoteAddress() + "] 的消息: " + byteBuf.toString(CharsetUtil.UTF_8));
                                    }
                                    super.channelRead(ctx, msg);
                                }
                            });
                        }
                    });
            System.out.println("Client is ready, time to send message.");
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 23456).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            eventExecutors.shutdownGracefully();
        }


    }
}
