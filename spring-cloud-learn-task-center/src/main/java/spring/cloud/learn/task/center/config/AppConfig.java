package spring.cloud.learn.task.center.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.cloud.learn.task.center.service.NodeManager;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/2/6
 * @since Jdk 1.8
 */
@Configuration
public class AppConfig {

    @Bean
    NodeManager nodeManager(@Autowired DiscoveryClient discoveryClient){
        NodeManager nodeManager = new NodeManager(discoveryClient);
        return nodeManager;
    }
}
