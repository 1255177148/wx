package com.hezhan.wx.controller;

import com.hezhan.wx.service.WxCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zhanzhan
 * @Date 2020/2/21 9:22
 */
@RestController
@RequestMapping("/api/wx")
public class WxDemoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxCheckService wxCheckService;

    @GetMapping("/test")
    public String checkAuth(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
                            @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr){
        logger.info("Begin do checkAuth------------>");
        return wxCheckService.check(signature, timestamp, nonce, echostr);
    }
}
