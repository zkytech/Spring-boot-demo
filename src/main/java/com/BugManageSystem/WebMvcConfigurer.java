package com.BugManageSystem;

import com.BugManageSystem.Interceptor.adminInterceptor;
import com.BugManageSystem.Interceptor.signinInterceptor;
import com.BugManageSystem.Listener.SessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> excludePath_login = Arrays.asList("/signup","/signin","/index","/init", "/error","/addbugtype","/","/static/**","/test");
        registry.addInterceptor(new signinInterceptor()).order(1).addPathPatterns("/**").excludePathPatterns(excludePath_login);
        registry.addInterceptor(new adminInterceptor()).order(2).addPathPatterns("/admin/**").excludePathPatterns(excludePath_login);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new SessionListener());
        return srb;
    }
}
