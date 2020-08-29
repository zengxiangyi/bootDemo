package com.app.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskJob {
	
	@Scheduled(cron = "0/5 * * * * ?")
	public void fixTimeExecution() {
		
	}
}
