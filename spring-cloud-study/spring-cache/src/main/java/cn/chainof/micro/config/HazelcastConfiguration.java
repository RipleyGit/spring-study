package cn.chainof.micro.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {
    @Bean
    public Config hazelCastConfig() {
        //如果有集群管理中心，可以配置
        ManagementCenterConfig centerConfig = new ManagementCenterConfig();
        centerConfig.setUrl("http://http://192.168.90.144/:9090/mancenter");
        centerConfig.setEnabled(true);
        return new Config()
                .setInstanceName("hazelcast-instance")
                .setManagementCenterConfig(centerConfig)
                .addMapConfig(
                        new MapConfig()
                                .setName("instruments")
                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setTimeToLiveSeconds(20000));
    }
}