package spring.cloud.learn.zuul.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/29
 * @since Jdk 1.8
 */
@Component
public class PostFilter extends ZuulFilter {

    private static Logger logger = Logger.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        logger.info("进入post过滤器");
        System.out.println(ctx.getResponseBody());

//        ctx.setResponseBody("post后置数据");

        return null;
    }
}
