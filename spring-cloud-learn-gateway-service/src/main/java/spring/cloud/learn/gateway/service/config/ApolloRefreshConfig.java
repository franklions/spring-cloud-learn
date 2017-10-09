package spring.cloud.learn.gateway.service.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/30
 * @since Jdk 1.8
 */
@Component
public class ApolloRefreshConfig {
        private static final Logger logger = LoggerFactory.getLogger(ApolloRefreshConfig.class);

        @Autowired
    private RefreshScope refreshScope;

        @Autowired
    private ContextRefresher contextRefresher;

    @ApolloConfigChangeListener({"application"})
    public void onAppChange(ConfigChangeEvent changeEvent) {
        logger.info("onAppChange");
        contextRefresher.refresh();
    }

    @ApolloConfigChangeListener({"application-dev"})
    public void onDevChange(ConfigChangeEvent changeEvent) {
        logger.info("ondevChange");
        refreshScope.refresh("gatewayConfigProperties");
    }
}
