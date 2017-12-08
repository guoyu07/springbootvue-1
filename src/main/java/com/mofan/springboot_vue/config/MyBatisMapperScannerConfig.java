package com.mofan.springboot_vue.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
    	MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    	mapperScannerConfigurer.setBasePackage("com.mofan.springboot_vue.mapper");
    	mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    	return mapperScannerConfigurer;
    }
}
