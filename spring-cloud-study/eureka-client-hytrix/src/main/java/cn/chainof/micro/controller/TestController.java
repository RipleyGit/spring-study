package cn.chainof.micro.controller;

import cn.chainof.micro.config.HystrixContext;
import cn.chainof.micro.feign.ClientSentryFeign;
import cn.chainof.micro.feign.ClientSentryFeignPoxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Watter on 2018-03-22
 */
@RestController
public class TestController {

    @Autowired
    private ClientSentryFeign clientSentryFeign;

    @Autowired
    private ClientSentryFeignPoxy clientSentryFeignPoxy;

    @GetMapping("/timeOut")
    public String whoAmI(@RequestParam int mills) {
        String timeOut = clientSentryFeign.timeOut(mills);
        System.out.println(timeOut);
        return timeOut;
    }


    @GetMapping("/hello")
    public String hello(@RequestParam String mills) {
        HystrixContext.getInstance();
        String timeOut1 = clientSentryFeignPoxy.testCache(mills);
        System.out.println("第一次请求："+timeOut1);
        String timeOut2 = clientSentryFeignPoxy.testCache(mills);
        System.out.println("第二次请求："+timeOut2);
        return timeOut2;
    }
}
