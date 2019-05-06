package com.example.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTaskJob {
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	//3秒执行一次任务
//	@Scheduled(fixedRate = 3000)
//	@Scheduled(cron = "")
	public void testJob() {
		System.out.println("现在时间:" + sdf.format(new Date()));
	}
	
	
}
