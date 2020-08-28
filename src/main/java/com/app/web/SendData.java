package com.app.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.javabean.User;
import com.app.util.JsonUtil;

@RestController
@RequestMapping("/post")
public class SendData {
	private static Logger log = LoggerFactory.getLogger(SendData.class);
	
	@PostMapping("/send")
	public String index(@RequestBody Map<String,Object> paramMap) {
		if(!paramMap.isEmpty()) {
			for(String key:paramMap.keySet()) {
				log.info(key+""+JsonUtil.toJsonStr(paramMap.get(key)));
			}
		}
		return JsonUtil.toJsonStr(paramMap);
	}
	
	@PostMapping("/user")
	public String printUser(@RequestBody User user) {		
		return JsonUtil.toJsonStr(user);
	}
	
	@PostMapping("/ids")
	public String printUser(@RequestBody List<String> ids) {		
		return JsonUtil.toJsonStr(ids);
	}
}
