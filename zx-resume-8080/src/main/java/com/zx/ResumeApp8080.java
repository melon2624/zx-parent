package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangxin
 * @date 2021/9/5 12:58
 */
@SpringBootApplication
@EnableEurekaClient  // 开启Eureka Client（Eureka独有）
//@EnableDiscoveryClient
public class ResumeApp8080 {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApp8080.class,args);
    }
}
