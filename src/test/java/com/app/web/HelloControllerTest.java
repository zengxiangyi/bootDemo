package com.app.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloControllerTest {

	private static Logger log = LoggerFactory.getLogger(HelloControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		log.info("测试开始");
	}

	@BeforeEach
	void setUp() throws Exception {
		log.info("每个方法测试开始");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.info("每个方法测试结束");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		log.info("测试结束");
	}

	@Test
	@Order(2)
	void testGetDataList() {
		log.info("测试方法2");
	}

	@Test
	@Order(1)
	void testHello() {
		try {
			mockMvc.perform(get("/hello/world")).andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.content().string("hello world")).andDo(print());
			// Assert.assertEquals("hello lvgang",content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
