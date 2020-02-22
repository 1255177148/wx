package com.hezhan.wx.service;

public interface WxCheckService {

    /**
     * 微信接入校验，验证签名
     * @param signature 待验证的签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 随机字符串
     * @return 验证成功与否，如果验证成功，则返回echostr，否则返回空
     */
    String check(String signature, String timestamp, String nonce, String echostr);
}
