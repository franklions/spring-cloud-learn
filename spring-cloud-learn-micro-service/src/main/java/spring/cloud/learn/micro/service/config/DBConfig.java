package spring.cloud.learn.micro.service.config;

//import com.ctrip.framework.apollo.model.ConfigChangeEvent;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
//import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/27
 * @since Jdk 1.8
 */
@Configuration
public class DBConfig {

    private static Logger logger = Logger.getLogger(DBConfig.class);

//    @Autowired
//    private org.springframework.cloud.context.scope.refresh.RefreshScope refreshScope;

    @Bean
//    @RefreshScope
    public DataSource dataSource(@Value("${spring.datasource.driver-class-name}") String driver,
                                 @Value("${spring.datasource.url}") String url,
                                 @Value("${spring.datasource.username}") String username,
                                 @Value("${spring.datasource.password}") String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


}
