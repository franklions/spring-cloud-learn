package spring.cloud.learn.zipkin.stream.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/6/16
 * @since Jdk 1.8
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinStreamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinStreamApplication.class,args);
    }
}
