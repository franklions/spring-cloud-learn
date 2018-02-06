package spring.cloud.learn.micro.service.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.learn.micro.service.service.UserServiceImpl;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/6/15
 * @since Jdk 1.8
 */
@RestController
public class ValuesController {

    private final Logger log = Logger.getLogger(ValuesController.class);

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CounterService counterService;

    @GetMapping("/value")
    public String getValues(){
        return "Sever values";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id){

        log.info("/user/"+id);

        counterService.increment("micro.user.count");
        return userService.getUserById(id).toString();
    }
}
