package cn.chainof.micro.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "instruments")
public class HazelcastService {
    @CacheEvict(allEntries = true)
    public void clearCache(){}

    @Cacheable(key = "#key")
    public String greet(String key) {
        System.out.println("缓存内没有取到key={}"+ key);
        return "world！";
    }
}
