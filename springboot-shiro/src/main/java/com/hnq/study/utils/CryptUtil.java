package com.hnq.study.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author henengqiang
 * @date 2018/9/21
 */
public class CryptUtil {

    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return     MD5结果
     */
    public static String md5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString();
    }

    public static String md5Salt(String data, String salt) {
        String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        return new SimpleHash(hashAlgorithmName, data, credentialsSalt, hashIterations).toString();
    }

    public static void main(String[] args) {
        System.out.println(md5Salt("123456", "hanif"));
    }

}
