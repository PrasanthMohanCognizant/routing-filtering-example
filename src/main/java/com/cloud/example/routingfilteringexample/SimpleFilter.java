package com.cloud.example.routingfilteringexample;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class SimpleFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest httpServletRequest = requestContext.getRequest();

        logger.info("Request Method : " + httpServletRequest.getMethod());

        return null;
    }
}
