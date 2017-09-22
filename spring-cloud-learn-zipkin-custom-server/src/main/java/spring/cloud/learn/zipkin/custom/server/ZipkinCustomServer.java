package spring.cloud.learn.zipkin.custom.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/7/14
 * @since Jdk 1.8
 */
@SpringBootApplication
public class ZipkinCustomServer {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinCustomServer.class,args);
    }
}
