package spring.cloud.learn.eureka.cluster;

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
@EnableEurekaServer
@SpringBootApplication
public class ClusterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClusterApplication.class,args);
        System.out.println("RunApplication.main>>>>>>>>>>>>>>>>>服务启动完成>>>>>>>>>>>>");
    }
}
