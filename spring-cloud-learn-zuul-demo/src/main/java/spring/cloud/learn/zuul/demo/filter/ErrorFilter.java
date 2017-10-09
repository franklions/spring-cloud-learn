package spring.cloud.learn.zuul.demo.filter;

import com.netflix.discovery.converters.Auto;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/9/29
 * @since Jdk 1.8
 */
@Component
public class ErrorFilter extends ZuulFilter {

    private Logger logger = Logger.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
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

        logger.info("进入异常过滤器");
        RequestContext ctx = RequestContext.getCurrentContext();

        Throwable throwable = ctx.getThrowable();
        logger.error("this is a ErrorFilter : "+throwable.getCause().getMessage(),throwable.getCause());
        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.exception", throwable.getCause());

        return null;
    }
}
