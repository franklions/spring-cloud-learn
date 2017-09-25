package spring.cloud.learn.gateway.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.cloud.learn.gateway.service.config.GatewayConfigProperties;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/25
 * @since Jdk 1.8
 */
public class GatewayService {
    private GatewayConfigProperties properties;

    public GatewayService(){}

    public GatewayService(GatewayConfigProperties properties) {
        this.properties = properties;
    }
}
