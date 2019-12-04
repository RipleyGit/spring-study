package cn.chainof.micro.controller;

import cn.chainof.micro.model.Customer;
import cn.chainof.micro.service.HazelcastService;
import com.hazelcast.core.Hazelcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by Watter on 2018-03-22
 */
@RestController
public class HazelcastController {

    private static String name ="client-sentry-one";

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private HazelcastService hazelcastService;

    private static int i=0;
    @GetMapping("/greet")
    public Object greet() {
        Object value = Hazelcast.getHazelcastInstanceByName("hazelcast-instance").getMap("instruments").get("hello");
        if (Objects.isNull(value)) {
            Hazelcast.getHazelcastInstanceByName("hazelcast-instance").getMap("instruments").put("hello", "world!");
        }
        return value;
    }
    @GetMapping("/cache")
    public Object cache() {
        String value = hazelcastService.greet("hello");
        return value;
    }
}
