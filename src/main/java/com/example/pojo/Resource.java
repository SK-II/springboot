package com.example.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration   //配置类
@ConfigurationProperties(prefix="ysl")  //配置文件中的前缀
@PropertySource(value="classpath:source.properties")
@Data
public class Resource {
	
	private String java;
	private String kafka;
	private String recketMQ;
	
}
