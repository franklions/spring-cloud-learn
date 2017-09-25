package spring.cloud.learn.micro.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/25
 * @since Jdk 1.8
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private Integer port;

    @RequestMapping("/addr")
    public String address(){
        return host +":"+port;
    }
}
