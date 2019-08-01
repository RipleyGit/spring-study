package cn.chainof.micro.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientSentryFeignPoxy {

    @Autowired
    ClientSentryFeign clientSentryFeign;


    @CacheResult
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="requestCache.enabled",value = "true")
    })
    public String testCache(@CacheKey("str") String mills){
        String timeOut = clientSentryFeign.testCache(mills);
        return timeOut;
    }

}
