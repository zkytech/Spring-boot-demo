package com.BugManageSystem;

import com.BugManageSystem.Interceptor.adminInterceptor;
import com.BugManageSystem.Interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> excludePath_login = Arrays.asList("/signup","/login", "/error","/addbugtype","/","/css/**","/js/**","/test");
        registry.addInterceptor(new loginInterceptor()).order(1).addPathPatterns("/**").excludePathPatterns(excludePath_login);
        registry.addInterceptor(new adminInterceptor()).order(2).addPathPatterns("/admin/**").excludePathPatterns(excludePath_login);
    }
}
