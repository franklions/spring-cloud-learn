package spring.cloud.learn.micro.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/6/15
 * @since Jdk 1.8
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MicroApplication.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
