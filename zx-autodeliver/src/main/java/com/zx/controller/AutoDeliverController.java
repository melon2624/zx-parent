package com.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhangxin
 * @date 2021/9/5 15:46
 */
@RestController
@RequestMapping("/autodeliver")
public class AutoDeliverController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //TODO  从Eureka Server中获取我们关注的那个服务的实例信息以及接口信息
        // 1、从 Eureka Server中获取lagou-service-resume服务的实例信息（使用客户端对象做这件事）
        List<ServiceInstance> instances = discoveryClient.getInstances("ZX-RESUME");
        // 2、如果有多个实例，选择一个使用(负载均衡的过程)
        ServiceInstance serviceInstance = instances.get(0);
        // 3、从元数据信息获取host port
        String host=serviceInstance.getHost();
         int port= serviceInstance.getPort();
//         String url="http://"+host+":"+port+"/resume/openstate/"+userId;
        //负载均衡
        String url="http://zx-resume/resume/openstate/"+userId;
         Integer forObject=restTemplate.getForObject(url,Integer.class);

        return forObject;
    }

}
