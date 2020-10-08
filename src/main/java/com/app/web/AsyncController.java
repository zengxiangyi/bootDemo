package com.app.web;

import org.springframework.scheduling.annotation.Async;

public class AsyncController {

	@Async("taskExecutor")
	public void TaskJob2() {
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName());
		System.out.println(end - start);
	}
}
