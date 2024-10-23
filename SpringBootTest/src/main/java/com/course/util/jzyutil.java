package com.course.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class jzyutil {

    public static String encryptToMD5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
    };

}
