package com.hezhan.wx.util;

import com.hezhan.wx.exception.CustomException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * @Author Zhanzhan
 * @Date 2020/2/22 15:40
 * 加密工具类
 */
@Component
public class EncryptionUtils {

    /**
     * 根据传入的算法类型进行简单的摘要加密算法
     *
     * @param data 要加密的数据
     * @param type 加密算法类型
     * @return 加密后的数据
     */
    public String digestEncryption(String data, String type) {
        try {
            MessageDigest md = MessageDigest.getInstance(type);
            byte[] digest = md.digest(data.getBytes());
            return Hex.encodeHexString(digest);
        } catch (Exception e) {
            throw new CustomException("加密时报错");
        }
    }

    /**
     * 将加密后的byte数组转为String
     * @param data
     * @return
     */
    private String byteArrayToString(byte[] data){
        StringBuffer sb = new StringBuffer(data.length * 2);
        String temp = null;
        for (byte b : data){
            temp = Integer.toHexString(b & 0xFF);
            if (temp.length() == 1){
                sb.append("0");
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    /**
     * 将加密后的byte数组转为String
     * @param data
     * @return
     */
    private String byteToString(byte[] data) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        int j = data.length;
        char buf[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = data[i];
            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
            buf[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(buf);
    }
}
