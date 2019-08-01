package cn.chainof.micro.controller;

import cn.chainof.micro.feign.ClientSentryFeign;
import cn.chainof.micro.feign.ClientSentryFeignPoxy;
import cn.chainof.micro.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

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
    public void hello() {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            Future<User> f1 = clientSentryFeignPoxy.findAn(1L);
            Future<User> f2 = clientSentryFeignPoxy.findAn(2L);
            Future<User> f3 = clientSentryFeignPoxy.findAn(3L);
            Thread.sleep(1000);
            Future<User> f4 = clientSentryFeignPoxy.findAn(4L);
            Future<User> f5 = clientSentryFeignPoxy.findAn(5L);

            User u1 = f1.get();
            User u2 = f2.get();
            User u3 = f3.get();

            User u4 = f4.get();
            User u5 = f5.get();
            System.out.println(u1.getName());
            System.out.println(u2.getName());
            System.out.println(u3.getName());
            System.out.println(u4.getName());
            System.out.println(u5.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            context.close();
        }
    }
}
