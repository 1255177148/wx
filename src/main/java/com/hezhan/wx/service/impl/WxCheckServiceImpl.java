package com.hezhan.wx.service.impl;

import com.hezhan.wx.service.WxCheckService;
import com.hezhan.wx.util.EncryptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Author Zhanzhan
 * @Date 2020/2/22 15:23
 */
@Service
public class WxCheckServiceImpl implements WxCheckService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EncryptionUtils encryptionUtils;

    @Value("${weixin.token}")
    private String token;

    @Override
    public String check(String signature, String timestamp, String nonce, String echostr) {
        logger.info("signature=" + signature +",timestamp=" + timestamp + "nonce=" + nonce + "echostr=" + echostr);
        //1) 将token、timestamp、nonce三个参数进行字典排序
        String[] str = {token, timestamp, nonce};
        Arrays.sort(str);
        //2) 将三个参数字符串拼接成一个字符串进行sha1加密
        String data = StringUtils.join(str);
        String result = encryptionUtils.digestEncryption(data, "sha1");
        logger.info("result=" + result);
        if (result.equals(signature)){
            return echostr;
        } else {
            return null;
        }
    }
}
