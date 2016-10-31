package com.zslin.web.tools;

import com.zslin.basic.tools.SecurityUtil;

import java.security.NoSuchAlgorithmException;

/**
 * 处理地址代码的工具类
 * Created by 钟述林 393156105@qq.com on 2016/10/30 10:33.
 */
public class AddrCodeTools {

    /** 生成地址代码 */
    public static String buildCode(String address) {
        String res = "";
        try {
            res = SecurityUtil.md5(address);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return res;
    }
}
