package spring.cloud.learn.gateway.service.controller;

import com.iemylife.iot.webtoolkit.IotHttp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/6/15
 * @since Jdk 1.8
 */
@RestController
public class ProxyController {

//    private final Logger log = Logger.getLogger(ProxyController.class);

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    IotHttp iotHttp;

    @GetMapping("/proxy/value")
    public String getValues(){
        return getValueService();
    }

    @HystrixCommand(fallbackMethod = "ShowServiceFallback")
    private String getValueService(){
//        return  restTemplate.getForEntity("http://zuul-v0/v0/micro/value",String.class).getBody();
       return   iotHttp.get("http://zuul-v0/v0/micro/value",String.class).getValue().get();
    }
}
