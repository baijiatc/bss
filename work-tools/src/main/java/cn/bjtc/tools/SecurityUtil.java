package cn.bjtc.tools;

import java.security.MessageDigest;

/**
 * 安全处理攻击类
 * @author Fischer
 *
 */
public class SecurityUtil {
    
    /**
     * 执行MD5加密
     * @param source 需要加密的原字符串
     * @return
     */
    public static String encodeByMD5(String source){
    	return encodeByMD5(source,DEFAULT_ENCODING);
    }
    /**
     * 执行MD5加密
     * @param source 需要加密的原字符串
     * @param encoding 指定编码类型 默认UTF-8
     * @return
     */
    public static String encodeByMD5(String source, String encoding) {
        String result = null;
        try {
            result = source+SALT;
            // 获得MD5摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 使用指定的字节数组更新摘要信息
            messageDigest.update(result.getBytes(encoding));
            // messageDigest.digest()获得16位长度
            result = byteArrayToHexString(messageDigest.digest());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toUpperCase();
    }
    
    /**
     * 获取默认编码格式
     * @return
     */
    public static String getDefaultEncoding(){
    	return DEFAULT_ENCODING;
    }

    /**
     * 转换字节数组为16进制字符串
     * @param bytes 字节数组
     * @return
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte tem : bytes) {
            stringBuilder.append(byteToHexString(tem));
        }
        return stringBuilder.toString();
    }

    /**
     * 转换byte到16进制
     * 
     * @param b
     *            要转换的byte
     * @return 16进制对应的字符
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }
    
    /** 16进制的字符数组 */
    private final static String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d","e", "f" };
    private final static String SALT = "BJTC";
    private final static String DEFAULT_ENCODING = "UTF-8";
    
}
