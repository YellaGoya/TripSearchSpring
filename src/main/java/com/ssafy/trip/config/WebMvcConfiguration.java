package com.ssafy.trip.config;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.trip.interceptor.ConfirmInterceptor;

@Configuration
@MapperScan(basePackages = {"com.ssafy.trip.**.mapper"})
public class WebMvcConfiguration implements WebMvcConfigurer{

	private final List<String> patterns = Arrays.asList("/", "/board/*", "/user/list");
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/upload/image/**").addResourceLocations("file://c:/aaa/aa");
//	}


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
//			.allowedOrigins("http://www.ssafy.com", "http://localhost", "http://localhost:8080"));
			.allowedMethods("GET", "POST", "PUT", "DELETE")
//			.allowedMethods(RequestMethod.GET.name(), RequestMethod.POST.name());
//			.allowedMethods("*")
			.maxAge(1800);
			
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	
}
