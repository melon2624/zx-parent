package com.zx.service;

import com.zx.feignApi.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * 降级回退逻辑需要定义一个类，实现FeignClient接口，实现接口中的方法
 * @author zhangxin
 * @date 2021/9/13 0:14
 */
@Component
public class MyFallback implements HelloRemote {
    @Override
    public String getZhangxin() {
        return "fallBackZhangxin";
    }

    @Override
    public String hello(String param) {
        return "fallBackHello";
    }
}
