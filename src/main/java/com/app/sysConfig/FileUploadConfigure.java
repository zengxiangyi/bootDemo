package com.app.sysConfig;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@Configuration
public class FileUploadConfigure {
	@Bean
	    public MultipartConfigElement multipartConfigElement() {
	        MultipartConfigFactory factory = new MultipartConfigFactory();
			factory.setMaxFileSize(DataSize.ofMegabytes(100));
			factory.setMaxRequestSize(DataSize.ofMegabytes(100));
	        return factory.createMultipartConfig();
	    }
}

