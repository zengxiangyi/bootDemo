package com.app.job;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.util.JsonUtil;

@Component
public class TaskJob {
	private static Logger log = LoggerFactory.getLogger(TaskJob.class);
	
	@Scheduled(cron = "0/5 * * * * ?")
	public void fixTimeExecution() {
		log.info(JsonUtil.toJsonStr(LocalDateTime.now()));
	}
}
