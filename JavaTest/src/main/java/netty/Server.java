package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * netty服务测试类--服务端
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/7/4 00:06
 */
public class Server {
    /**
     * 服务端端口号，需要注意，服务端是不需要绑定任何地址的，因为服务端是提供服务的。
     */
    private String port;

    public static void main(String[] args) {
        // 监听和控制线程，对应dubbo来说是否一个应用中只需要开启一个来进行处理即可
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 工作线程（用于处理每个请求）
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 在启动器中设置两个线程池，前者为parentGroup而后者则为childGroup
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            // 这里添加了ChannelHandlers，需要注意在进行实际的channel处理之前需要对获取到的信息进行消息内容进行过滤和粘包等问题处理
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                // 实际消息的处理器，这里其实需要针对消息内容的不同进行不同的处理
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    if (msg instanceof ByteBuf) {
                                        // 此处一定要转成ByteBuf类型的对象才能进行下一步的处理操作
                                        ByteBuf byteBuf = (ByteBuf) msg;
                                        // 这里在进行数据打印的时候一定需要指定对应的编码集
                                        System.out.println("收到客户端 [" + ctx.channel().remoteAddress() + "] 消息: " + byteBuf.toString(CharsetUtil.UTF_8));
                                    }
                                    super.channelRead(ctx, msg);
                                }

                                @Override
                                public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
                                    ctx.writeAndFlush(Unpooled.copiedBuffer("服务端接收到消息, 并发送了一个ok", CharsetUtil.UTF_8));
                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                    ctx.close();
                                }
                            });
                        }
                    });
            // 绑定对应端口号并启动服务端
            ChannelFuture channelFuture = bootstrap.bind(23456).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 在当前进程结束时需要进行优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
