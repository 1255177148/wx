package com.hezhan.wx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zhanzhan
 * @Date 2020/2/21 9:22
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/link")
    public String testLink(){
        logger.info("Begin do testLink------------->");
        return "已连接";
    }
}
