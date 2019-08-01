package cn.chainof.micro.feign;

import cn.chainof.micro.model.User;
import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Component
public class ClientSentryFeignPoxy {

    @Autowired
    ClientSentryFeign clientSentryFeign;


    @HystrixCollapser(batchMethod = "findAnAll",
            collapserProperties = {@HystrixProperty(name ="timerDelayInMilliseconds",value = "1000")})
    public Future<User> findAn(Long id) {
        User user = clientSentryFeign.singleUser(String.valueOf(id));
        return new AsyncResult<>(user);
    }

    @HystrixCommand
    public List<User> findAnAll(List<Long> ids) {
        System.out.println("finaAnAll request:---------" + ids + "Thread.currentThread().getName():-------" + Thread.currentThread().getName());
        List<User> list = clientSentryFeign.batchUser(StringUtils.join(ids, ","));
        return list;
    }

}
