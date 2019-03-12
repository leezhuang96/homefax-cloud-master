package com.homefax.api.filter;

import com.homefax.util.BodyReaderHttpServletRequestWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description: 改过滤器用于处理request 使request.getInputStream()方法可以重复读取流中数据
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/25 15:34
 * @Create Author: nevermore
 * @File Name: RequestFilter
 * @Last version: 1.0.0
 */

@Component
@WebFilter(urlPatterns = "/*", filterName = "requestFilter")
public class RequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
