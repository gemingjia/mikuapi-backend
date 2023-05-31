package com.miku.openapi.common;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;

/**
 * 签名工具类
 */
public class KeyUtils {

    public static final String SALT = "miku";

    /**
     * 生成accessKey
     * @param param 用户账号
     * @return
     */
    public static String getAccessKey(String param) {
        return DigestUtil.md5Hex(SALT + param + RandomUtil.randomNumbers(5)
                + System.currentTimeMillis());
    }

    /**
     * 生成secretKey
     * @param param 用户账号
     * @return
     */
    public static String getSecretKey(String param) {
       return DigestUtil.md5Hex(SALT + param + RandomUtil.randomNumbers(6)
                + System.currentTimeMillis());
    }
}
