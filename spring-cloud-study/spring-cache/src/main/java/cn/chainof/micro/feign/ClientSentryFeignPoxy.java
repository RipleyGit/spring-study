package cn.chainof.micro.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientSentryFeignPoxy {

    @Autowired
    ClientSentryFeign clientSentryFeign;


    public String testCache(String mills){
        String timeOut = clientSentryFeign.testCache(mills);
        return timeOut;
    }

    public String getMillsCacheKey(String mills) {
        return mills;
    }

}
