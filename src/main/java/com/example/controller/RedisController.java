package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.result.ResponseResult;
import com.example.utils.RedisOperator;

@RestController
public class RedisController {
	
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private RedisOperator redisOperator;
	
	@GetMapping("/redisIndex")
	public ResponseResult redisIndex() {
//		redisTemplate.opsForValue().set("ysl", "redisTemplate");
		redisOperator.set("ysl", "redisTemplate");
		return ResponseResult.resultSuccess(redisTemplate.opsForValue().get("ysl"));
	}
	
}
