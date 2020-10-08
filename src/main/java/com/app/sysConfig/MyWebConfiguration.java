package com.app.sysConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 配置服务支持跨域访问
 */
@Configuration
public class MyWebConfiguration extends WebMvcConfigurationSupport {

	/**
	 * 解决跨域问题
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		System.out.println("启动CROS配置");
		registry.addMapping("/**").allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH").allowedOrigins("*")
				.maxAge(3600).allowCredentials(true).allowedHeaders("*").exposedHeaders("access-control-allow-headers",
						"access-control-allow-methods", "access-control-allow-origin", "access-control-max-age",
						"X-Frame-Options");
		super.addCorsMappings(registry);
	}

}