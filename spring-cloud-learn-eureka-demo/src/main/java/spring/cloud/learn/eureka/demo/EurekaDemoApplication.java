package spring.cloud.learn.eureka.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/6/15
 * @since Jdk 1.8
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaDemoApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(EurekaDemoApplication.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
