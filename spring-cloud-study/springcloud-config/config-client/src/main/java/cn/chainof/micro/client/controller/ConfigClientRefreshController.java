package cn.chainof.micro.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientRefreshController {

    @Value("${from}")
    private String value;

    @RequestMapping("/hello")
    public String hello() {
        return "hello" + value;
    }
}
