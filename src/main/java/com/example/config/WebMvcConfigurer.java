package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.handler.TestInterceptor;


@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new TestInterceptor()).addPathPatterns("/two/**")
													 .addPathPatterns("/one/**");
		registry.addInterceptor(new TestInterceptor()).addPathPatterns("/one/**");
		
		super.addInterceptors(registry);
	}

}
