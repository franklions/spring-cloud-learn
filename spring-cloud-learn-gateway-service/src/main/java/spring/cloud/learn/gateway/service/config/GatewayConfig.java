package spring.cloud.learn.gateway.service.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.cloud.learn.gateway.service.service.GatewayService;

import javax.annotation.Resource;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/25
 * @since Jdk 1.8
 */
@Configuration
@EnableApolloConfig(value = {"application","application-dev"}, order = 10)
public class GatewayConfig {

}
