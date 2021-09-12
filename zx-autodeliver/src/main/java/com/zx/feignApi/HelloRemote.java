package com.zx.feignApi;

import com.zx.service.MyFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "zx-resume",fallback = MyFallback.class,path = "/resume")
//@RequestMapping("/resume")
public interface HelloRemote {

    @RequestMapping("/hello2")
    public String getZhangxin();

    @RequestMapping("/hello")
    public String  hello(@RequestParam String param);
}
