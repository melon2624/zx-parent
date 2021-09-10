package com.zx.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zx.feignApi.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
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


    @Autowired
    private HelloRemote helloRemote ;

    /*@HystrixCommand(
            // 线程池标识，要保持唯⼀，不唯⼀的话就共⽤了
            threadPoolKey = "findResumeOpenStateTimeout",
            // 线程池细节属性配置
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value =
                            "1"), // 线程数
                    @HystrixProperty(name = "maxQueueSize", value = "20") // 等待队列⻓度
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            }
    )*/
    @RequestMapping("/hello/zx")
    public String hello() {
         return helloRemote.hello("zhangxin");
        //return null;
    }

    @HystrixCommand(
            // 线程池标识，要保持唯⼀，不唯⼀的话就共⽤了
            threadPoolKey =
                    "findResumeOpenStateTimeoutFallback",
            // 线程池细节属性配置
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value =
                            "2"), // 线程数
                    @HystrixProperty(name = "maxQueueSize", value = "20") // 等待队列⻓度
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            }, fallbackMethod = "myfallback"
    )
    @RequestMapping("/hello2/zx")
    public String hello2() {
        return helloRemote.hello("zhangxin2");
    }

    public String myfallback() {
        return "-1";
    }

    @RequestMapping("/hello/test")
    public void test(HttpServletRequest request, @RequestParam(name = "zx") String zx) {

        String zm = request.getParameter("zm");

        System.out.print(Integer.parseInt("222"));

        //throw  new NullPointerException();
        this.zhangxin("zx");

    }

    public void zhangxin(String str) {
        if (str.equals("zx")) {
            throw new RuntimeException("错误");

            // throw  new NullPointerException();
        }

    }



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
