package spring.cloud.learn.gateway.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.cloud.learn.gateway.service.config.GatewayConfigProperties;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/6/15
 * @since Jdk 1.8
 */
@RefreshScope
@RestController
public class ProxyController {

    @Value("${label.value:123}")
    private String value;

    private final Logger log = Logger.getLogger(ProxyController.class);

    @Autowired
    GatewayConfigProperties configProperties;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/label/value")
    public String getLabelValue(){
        return this.value;
    }

    @GetMapping("/proxy/value")
    public String getValues(){
        return getValueService();
    }

    @HystrixCommand(fallbackMethod = "ShowServiceFallback")
    private String getValueService(){

        log.info(this.configProperties.getMicroUrl());
        log.info(this.configProperties.getZuulAppName());

        return  restTemplate.getForEntity("http://{0}/{1}",String.class,
                this.configProperties.getZuulAppName(),
                this.configProperties.getMicroUrl()).getBody();

    }

}
