package com.hair.config;

import com.netflix.discovery.converters.Auto;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.TraceProperties;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.cloud.netflix.zuul.filters.pre.FormBodyWrapperFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

@Component
public class TraceFilter extends ZuulFilter {

    @Autowired
    private TraceProperties traceProperties;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER -1 ;
    }

    @Override
    public boolean shouldFilter() {
        //根据配置是否开启过滤器
        return true;
    }

    @Override
    public Object run() {
        //链路追踪id
        return null;
    }
}
