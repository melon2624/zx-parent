package com.zx.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxin
 * @date 2021/9/5 16:03
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @RequestMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
        return 8081;
    }


    @RequestMapping("/hello2")
    public String getZhangxin(){
        return "zhangxin-hello";
    }

    @RequestMapping("/hello")
    public String  hello(@RequestParam String param){

        try {
            Thread.sleep(3000);
            System.out.println("8081");
        }catch (Exception e){
            e.printStackTrace();
        }

        return "zhangxin8081";
    }

}
