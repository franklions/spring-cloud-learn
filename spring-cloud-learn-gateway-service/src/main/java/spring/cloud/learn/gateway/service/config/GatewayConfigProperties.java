package spring.cloud.learn.gateway.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/25
 * @since Jdk 1.8
 */
@ConfigurationProperties("gateway")
@Component("gatewayConfigProperties")
@RefreshScope
public class GatewayConfigProperties {
    private String zuulAppName;
    private String microUrl;

    public String getZuulAppName() {
        return zuulAppName;
    }

    public void setZuulAppName(String zuulAppName) {
        this.zuulAppName = zuulAppName;
    }

    public String getMicroUrl() {
        return microUrl;
    }

    public void setMicroUrl(String microUrl) {
        this.microUrl = microUrl;
    }
}
