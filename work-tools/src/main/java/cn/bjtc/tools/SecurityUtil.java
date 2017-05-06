package cn.bjtc.tools;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

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
        return result;
    }
    
    public static String encodeByAES(String source){
    	return encodeByAES(source, DEFAULT_ENCODING);
    }
    
    public static String encodeByAES(String source, String encoding){
    	return doAES(source, encoding, Cipher.ENCRYPT_MODE);
    }
    
    public static String decodeByAES(String source){
    	return decodeByAES(source,DEFAULT_ENCODING);
    }
    
    public static String decodeByAES(String source, String encoding){
    	return doAES(source, encoding, Cipher.DECRYPT_MODE);
    }
    
    private static String doAES(String source, String encoding, int mode){
    	String result = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(DEFAULT_AES_DIGEST, new SecureRandom(SALT.getBytes(encoding)));
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
            switch(mode){
	            case Cipher.ENCRYPT_MODE:
	            	byte[] bytes = cipher.doFinal(source.getBytes(encoding));
	            	result = byteArrayToHexString(bytes);
	            	break;
	            case Cipher.DECRYPT_MODE:
	            	byte[] hexBytes = hexStringToByteArray(source);
	            	byte[] deBytes = cipher.doFinal(hexBytes);
	            	result = new String(deBytes);
	            	break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
    
    private static byte[] hexStringToByteArray(String hexString){
    	int len = hexString.length();
    	byte[] bytes = new byte[len/2];
    	int j = 0;
    	char[] hexChars = hexString.toCharArray();
    	for(int i = 0; i < len; i+=2){
    		char c1 = hexChars[i];
    		char c2 = hexChars[i+1];
    		int high = HEXCHARS_STRING.indexOf(c1);
    		int low = HEXCHARS_STRING.indexOf(c2);
    		int code = high * 16 + low;
    		byte b = (byte) code;
    		bytes[j] = b;
    		j++;
    	}
    	return bytes;
    	
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
    private final static String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D","E", "F" };
    private final static String HEXCHARS_STRING = "0123456789ABCDEF";
    private final static String SALT = "BJTC";
    private final static String DEFAULT_ENCODING = "UTF-8";
    private final static int DEFAULT_AES_DIGEST = 128;
    
}
