package com.mofan.springboot_vue;

import java.util.Map;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Maps;

@Configuration
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new StatViewServlet());
		registration.addUrlMappings("/druid/*");
		Map<String, String> initParameters = Maps.newHashMap();
		initParameters.put("allow", "127.0.0.1");
		registration.setInitParameters(initParameters);
		return registration;
	}
	
	@Bean
	public FilterRegistrationBean encodingFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new CharacterEncodingFilter());
		registration.setAsyncSupported(true);
		registration.addUrlPatterns("/*");
		Map<String, String> initParameters = Maps.newHashMap();
		initParameters.put("encoding", "UTF-8");
		registration.setInitParameters(initParameters);
		return registration;
	}

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverts(){
		//定义一个convert转换消息对象
		FastJsonHttpMessageConverter converter=new FastJsonHttpMessageConverter();
		//添加fastjson的配置信息，比如：是否要格式化返回fastjson
		FastJsonConfig config=new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//在convert中添加配置信息
		converter.setFastJsonConfig(config);
		HttpMessageConverter messageConverter=converter;
		return new HttpMessageConverters(messageConverter);
	}

}
