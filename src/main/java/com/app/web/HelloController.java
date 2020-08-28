package com.app.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/out")
	public List<String> getDataList(){
		return Arrays.asList("中国","美国","英国");
	}
	
	@GetMapping("/world")
	public String hello(){
		return "hello world";
	}
	
	public void tempCode() {
		/*
		   request = post("/loggers/logger.controller")
		   .contentType(MediaType.APPLICATION_JSON)
		   .content(JSONObject.toJSONString(map));
		 
		 
		 */
	}
}
