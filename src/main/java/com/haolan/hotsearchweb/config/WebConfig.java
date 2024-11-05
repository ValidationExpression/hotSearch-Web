package com.haolan.hotsearchweb.config;

import com.haolan.hotsearchweb.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: haolan
 * 拦截器配置
 * 作用：通过配置的方式将拦截器加入到spring容器中
 * 拦截器：在请求处理之前进行调用，只有拦截器返回true，才会继续执行请求处理，否则不会继续执行请求处理。
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录接口和注册接口不拦截，否则无法登录。
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");
    }
}
