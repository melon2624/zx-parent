package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhangxin
 * @date 2021/9/4 16:13
 */
@SpringBootApplication
// 声明本项⽬是⼀个Eureka服务
@EnableEurekaServer
public class EurekaApp8761 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApp8761.class,args);
    }

}
