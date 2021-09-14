package com.zx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhangxin
 * @date : 2021-09-14 10:58
 **/
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${zhangxin.age}")
    public  String age;

    @PostMapping("/viewconfig")
    public  String getConfig(){

        System.out.println("age--->"+age);

        return age;
    }
}
