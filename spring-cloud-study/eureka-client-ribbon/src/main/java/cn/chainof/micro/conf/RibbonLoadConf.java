package cn.chainof.micro.conf;

import cn.chainof.micro.anno.ExcludeFromComponentScan;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class RibbonLoadConf {
    @Bean
    public IRule ribbonRule(){

//        return new RandomRule();
        return null;
    }
}
