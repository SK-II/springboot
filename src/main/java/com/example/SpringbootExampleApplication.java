package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mapper
@MapperScan(basePackages= {"com.example.mapper"})
//扫描装配自定义工具类包所在的路径
@ComponentScan(basePackages= {"com.example","org.n3r.idworker"})
//开启定时任务
@EnableScheduling
//开启异步
@EnableAsync
public class SpringbootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExampleApplication.class, args);
	}

}
