package com.util;

/**
 * Created by sa on 2017-08-08.
 */
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码工具类
 * @author Herman.Xiong
 * @date 2015-7-10 上午10:52:15
 * @version V3.0
 * @since jdk 1.6,tomcat 6.0
 */
public class ZxingUtil {
    private static final Map<EncodeHintType, ErrorCorrectionLevel> encodeMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
    private static final Map<DecodeHintType, ErrorCorrectionLevel> decodeMap=new HashMap<DecodeHintType, ErrorCorrectionLevel>();
    private static final String charset="UTF-8",format="png";
    private static final int size=1000;
    private ZxingUtil() {}

    /**
     * 生成二维码图片
     * @author Herman.Xiong
     * @date 2015-7-10 上午10:26:33
     * @param file
     * @throws WriterException
     * @throws IOException
     */
    public static void createQRCode(String data, File file)
            throws WriterException, IOException {
        MatrixToImageWriter.writeToFile(new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, size, size, encodeMap), format, file);
    }

    /**
     * 读取二维码信息
     * @author Herman.Xiong
     * @date 2015-7-10 上午10:25:58
     * @param filePath 二维码图片路径
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NotFoundException
     */
    public static String readQRCode(String filePath)
            throws FileNotFoundException, IOException, NotFoundException {
        return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath))))),decodeMap).getText();
    }


//    public static void main(String [] arg){
//        try{
//            String qrcodePath="C:\\user\\"+"18899992222"+".png";
//            createQRCode("http://106.15.72.63:8088/index/registerByInvite?recommendPhone=18899992222", new File(qrcodePath));
//            System.out.println(readQRCode(qrcodePath));
//            //源码下载地址：http://download.csdn.net/detail/xmt1139057136/8886473
//            //欢迎大家关注我的博客！如有疑问,请加QQ群：454796847共同学习！
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}