package spring.cloud.learn.task.center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import spring.cloud.learn.task.center.service.NodeManager;

import java.util.List;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/2/5
 * @since Jdk 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TaskCenterApplication implements CommandLineRunner {

    @Autowired
    NodeManager nodeManager;

    public static void main(String[] args) {
        SpringApplication.run(TaskCenterApplication.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {
        nodeManager.show();
    }
}
