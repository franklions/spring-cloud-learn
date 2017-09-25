package spring.cloud.learn.gateway.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.cloud.learn.gateway.service.service.GatewayService;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/25
 * @since Jdk 1.8
 */
@Configuration
@RefreshScope
@EnableConfigurationProperties(GatewayConfigProperties.class)
public class GatewayConfig {

    @Autowired
    private GatewayConfigProperties configProperties;

    @Bean
    GatewayService getBean(){
        GatewayService service = new GatewayService(configProperties);
        return service;
    }

}
