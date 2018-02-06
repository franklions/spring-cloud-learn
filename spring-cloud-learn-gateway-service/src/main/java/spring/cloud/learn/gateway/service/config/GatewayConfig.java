package spring.cloud.learn.gateway.service.config;

//import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.uber.jaeger.samplers.ProbabilisticSampler;
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
@EnableConfigurationProperties(GatewayConfigProperties.class)
//@EnableApolloConfig(value = {"application","application-dev"}, order = 10)
public class GatewayConfig {
    @Bean
    public io.opentracing.Tracer jaegerTracer() {
        return new com.uber.jaeger.Configuration("spring-boot",
                new com.uber.jaeger.Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1, "192.168.12.54:5775"),
                    new com.uber.jaeger.Configuration.ReporterConfiguration(false,
                            "192.168.12.54",
                            5775,
                            1000,
                            100))
                .getTracer();
    }
}
