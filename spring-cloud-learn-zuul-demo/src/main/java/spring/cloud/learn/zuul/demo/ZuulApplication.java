package spring.cloud.learn.zuul.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2017/6/15
 * @since Jdk 1.8
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v\\d+$)",
                "${version}/${name}");
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
        System.out.println("RunApplication.main>>>>>>>>>>>服务启动完成>>>>>>>>>>>>>>>");
    }
}
