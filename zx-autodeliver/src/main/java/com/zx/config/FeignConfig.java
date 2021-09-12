package com.zx.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxin
 * @date 2021/9/12 22:25
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
