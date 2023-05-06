package com.kina.admin.config;

import com.kina.admin.interceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
// @EnableWebMvc:全面接管
/**
 * 1.静态资源？视图解析器？欢迎页？。。。。。所有的自动配置全部失效
 * 2.也就是需要自己定义,需要自己定义所有底层行为，这个注解一定要慎用
 */
@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     * 定义静态资源行为
     * 访问/aa/** 所有请求 都去classpath:/static/ 下面进行匹配
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // 所有请求都被拦截，静态资源一并拦截了
                .excludePathPatterns("/", "/login","/css/**", "/images/**", "/js/**", "/fonts/**");
    }
//    @Bean
//    public WebMvcRegistrations WebMvcRegistrations() {
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return null;
//            }
//        };
//    }
}
