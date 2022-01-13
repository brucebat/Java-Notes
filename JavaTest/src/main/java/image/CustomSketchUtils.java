package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * 自定义图片处理工具类
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/1/13 4:33 下午
 */
public class CustomSketchUtils {

    /**
     * 直角角度
     */
    private static final int RIGHT_ANGLE = 90;

    /**
     *
     */
    private static final int TWO = 2;

    /**
     * 根据指定宽高进行图片缩放
     *
     * @param textureImageUrl 用于贴图的图片
     * @param width           宽
     * @param height          高
     * @return 缩放完成图片
     */
    public static BufferedImage modifyImageScale(BufferedImage textureImageUrl, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        //设置图片透明  注: 只有png格式的图片才能设置背景透明，jpg设置图片颜色变的乱七八糟
        image = graphics2D.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        graphics2D = image.createGraphics();
        graphics2D.drawImage(textureImageUrl, 0, 0, width, height, null);
        graphics2D.dispose();
        return image;
    }


    /**
     * 进行图片旋转
     *
     * @param textureImageUrl 待处理图片
     * @param angle           旋转角度
     * @return 处理完成图片
     */
    public static BufferedImage modifyImageAngle(BufferedImage textureImageUrl, int angle) {
        int srcWidth = textureImageUrl.getWidth();
        int srcHeight = textureImageUrl.getHeight();
        //针对图片旋转重新计算图的宽*高
        Rectangle rectangle = calculateRotatedSize(new Rectangle(new Dimension(srcWidth, srcHeight)), angle);
        BufferedImage res = new BufferedImage(rectangle.width, rectangle.height, BufferedImage.TYPE_INT_RGB);
        //创建画布
        Graphics2D graphics2D = res.createGraphics();
        res = graphics2D.getDeviceConfiguration().createCompatibleImage(rectangle.width, rectangle.height, Transparency.TRANSLUCENT);
        graphics2D = res.createGraphics();
        //重新设定原点坐标
        graphics2D.translate((rectangle.width - srcWidth) / 2, (rectangle.height - srcHeight) / 2);
        // 执行图片旋转，rotate里包含了translate，并还原了原点坐标
        graphics2D.rotate(Math.toRadians(angle), srcWidth / 2, srcHeight / 2);
        graphics2D.drawImage(textureImageUrl, null, null);
        graphics2D.dispose();
        return res;
    }

    /**
     * 进行图片题图处理
     *
     * @param faceImage  人脸图片
     * @param background 背景图片
     * @return 合成完成图片
     */
    public static BufferedImage texture(BufferedImage faceImage, BufferedImage background, int x, int y) {
        try {
            // 生成一个带alpha通道的背景图
            BufferedImage backgroundCurtain = new BufferedImage(background.getWidth(), background.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = backgroundCurtain.createGraphics();
            graphics2D.drawImage(background, 0, 0, null);
            graphics2D.drawImage(faceImage, x, y, faceImage.getWidth(), faceImage.getHeight(), null);
            graphics2D.dispose();
            return backgroundCurtain;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取图片到缓冲
     *
     * @param imgUrl 背景地址
     */
    public static BufferedImage readImg(String imgUrl) {
        try {
            return ImageIO.read(new URL(imgUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("图片读取失败");
    }

    /**
     * 写入到输入流当中
     *
     * @param canvas 待导出图像
     * @return 输出流
     */
    private static InputStream write2InputStream(BufferedImage canvas) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {

            ImageIO.write(canvas, "png", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(os.toByteArray());
    }


    /**
     * 写入到本地
     *
     * @param canvas 待处理图片缓冲
     * @param path   待写入的本地文件
     */
    public static void write2Localhost(BufferedImage canvas, String path) {
        try {
            ImageIO.write(canvas, "png", new FileOutputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据旋转后图片重新计算宽高
     *
     * @param srcRectangle 来源区域
     * @param angel        旋转角度
     * @return 旋转完成区域
     */
    private static Rectangle calculateRotatedSize(Rectangle srcRectangle, int angel) {
        if (angel >= RIGHT_ANGLE) {
            if (angel / RIGHT_ANGLE % TWO == 1) {
                srcRectangle = new Rectangle(srcRectangle.x, srcRectangle.y, srcRectangle.height, srcRectangle.width);
            }
            angel = angel % RIGHT_ANGLE;
        }

        double r = Math.sqrt(srcRectangle.height * srcRectangle.height + srcRectangle.width * srcRectangle.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angelAlpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angelDaltWidth = Math.atan((double) srcRectangle.height / srcRectangle.width);
        double angelDaltHeight = Math.atan((double) srcRectangle.width / srcRectangle.height);
        int lenDaltWidth = (int) (len * Math.cos(Math.PI - angelAlpha
                - angelDaltWidth));
        int lenDaltHeight = (int) (len * Math.cos(Math.PI - angelAlpha
                - angelDaltHeight));
        int desWidth = srcRectangle.width + lenDaltWidth * 2;
        int desHeight = srcRectangle.height + lenDaltHeight * 2;
        return new Rectangle(new Dimension(desWidth, desHeight));
    }


    public static void main(String[] args) {
        String url = "xxxxxx";
        String url2 = "xxxxxxx";
        BufferedImage rotatedImage = modifyImageScale(readImg(url2), 480, 640);
        write2Localhost(rotatedImage, "/Users/suntianyu/Desktop/test2.png");
        rotatedImage = modifyImageAngle(rotatedImage, 90);
        write2Localhost(rotatedImage, "/Users/suntianyu/Desktop/test1.png");
        BufferedImage canvas = texture(rotatedImage, readImg(url), 200, 200);
        write2Localhost(canvas, "/Users/suntianyu/Desktop/test.png");
    }
}
