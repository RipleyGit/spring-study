package cn.chainof.micro.service;

import cn.chainof.micro.anno.HazelcastCache;
import cn.chainof.micro.conf.CacheConfig;
import org.springframework.stereotype.Service;

@Service
public class DisCacheService {

    @HazelcastCache(CacheConfig.CACHE_MAP)
    public String addCache(String key){
        return key + "hello distribute!";
    }
}
