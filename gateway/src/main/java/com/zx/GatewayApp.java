package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangxin
 * @date 2021/9/5 15:30
 */
@SpringBootApplication
@EnableDiscoveryClient
/*@EnableFeignClients
@EnableHystrix*/
public class GatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
