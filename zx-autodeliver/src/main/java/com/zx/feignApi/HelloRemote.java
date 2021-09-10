package com.zx.feignApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "zx-resume")
@RequestMapping("/resume")
public interface HelloRemote {

    @RequestMapping("/hello2")
    public String getZhangxin();

    @RequestMapping("/hello")
    public String  hello(@RequestParam String param);
}
