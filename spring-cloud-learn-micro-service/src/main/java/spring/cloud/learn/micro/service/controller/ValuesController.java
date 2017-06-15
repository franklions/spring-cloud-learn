package spring.cloud.learn.micro.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/6/15
 * @since Jdk 1.8
 */
@RestController
public class ValuesController {

    @GetMapping("/value")
    public String getValues(){
        return "Sever values";
    }
}
