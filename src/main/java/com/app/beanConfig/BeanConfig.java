package com.app.beanConfig;

import java.util.concurrent.ThreadPoolExecutor;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAsync
public class BeanConfig {

	@Bean("taskExecutor")
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 设置核心线程数
		executor.setCorePoolSize(10);
		// 设置最大线程数
		executor.setMaxPoolSize(16);
		// 设置队列容量
		executor.setQueueCapacity(100);
		// 设置线程活跃时间（秒）
		executor.setKeepAliveSeconds(60);
		// 设置默认线程名称
		executor.setThreadNamePrefix("kafka-");
		// 设置拒绝策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 等待所有任务结束后再关闭线程池
		executor.setWaitForTasksToCompleteOnShutdown(true);
		// 初始化
		executor.initialize();
		return executor;
	}
	
	@Bean
	public DataSource getDataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
		dataSourceConfig.setJdbcUrl("jdbc:mysql://190.2.96.72:3306/cc4util?characterEncoding=utf8&serverTimezone=PRC");
		dataSourceConfig.setUsername("root");
		dataSourceConfig.setPassword("P@ssw0rd");
		dataSourceConfig.setMaximumPoolSize(100);
		dataSourceConfig.setValidationTimeout(3000);
		dataSourceConfig.setMinimumIdle(10);
		dataSourceConfig.setMaxLifetime(180000);
		dataSourceConfig.setConnectionTimeout(60000);
		dataSourceConfig.setIdleTimeout(60000);
		dataSourceConfig.setInitializationFailTimeout(3000);
		dataSourceConfig.setPoolName("myDBPool");
		dataSourceConfig.setAutoCommit(true);
		dataSourceConfig.setConnectionTestQuery("SELECT 1");
		dataSourceConfig.addDataSourceProperty("cachePrepStmts", true);
		dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", 250);
		dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);		
		dataSourceConfig.addDataSourceProperty("useServerPrepStmts", true);
		dataSourceConfig.addDataSourceProperty("useLocalSessionState", true);
		dataSourceConfig.addDataSourceProperty("rewriteBatchedStatements", true);
		dataSourceConfig.addDataSourceProperty("cacheResultSetMetadata", true);
		dataSourceConfig.addDataSourceProperty("cacheServerConfiguration", true);
		dataSourceConfig.addDataSourceProperty("elideSetAutoCommits", true);
		dataSourceConfig.addDataSourceProperty("maintainTimeStats", false);
	    // 继续补充    
	    return new HikariDataSource(dataSourceConfig);
	//	return DataSourceBuilder.create().build();
	}

	
}