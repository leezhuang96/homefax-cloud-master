package com.homefax.api.interceptor;


import com.homefax.util.BodyReaderHttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/22 11:06
 * @Create Author: nevermore
 * @File Name: RequestInterceptor
 * @Last version: 1.0.0
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    private static final String startTime = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        logger.info("请求地址是：{}",url);
        request.setAttribute(startTime,System.currentTimeMillis());
        Map map = request.getParameterMap();
        Iterator iterator = map.entrySet().iterator();
        StringBuffer buffer = new StringBuffer("");
        while (iterator.hasNext()){
            Map.Entry entry =(Map.Entry) iterator.next();
            String[] value = (String[])entry.getValue();
            buffer.append(entry.getKey()).append("&").append(value[0]);
        }
        logger.info("请求头参数为{}",buffer.toString());
        logger.info("请求类型为"+request.getMethod());
        /*BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);
        logger.info("请求体参数为{}",responseStrBuilder.toString());*/
        if (request.getMethod() != "GET"){
            String body= (new BodyReaderHttpServletRequestWrapper(request).getBodyString(request));
            logger.info("请求体参数为{}",body);
        }

        //登陆注解校验
        /*HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(LoginCheck.class)) {
            // 使用@LoginCheck注解，则进行登录验证
           logger.info("需要登录校验");

        }*/
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long starTime = (long)request.getAttribute(startTime);
        long time = System.currentTimeMillis() - starTime;
        logger.info("方法执行时间为{}",time);

        super.afterCompletion(request, response, handler, ex);
    }
}
