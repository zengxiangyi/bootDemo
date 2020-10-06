
package com.app.junitcase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag("model")
@DisplayName("A stack")
@TestMethodOrder(OrderAnnotation.class)
class ComputeTest {
	private static Logger log = LoggerFactory.getLogger(ComputeTest.class);
	private static Compute compute;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		compute=new Compute();
		log.info("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		log.info("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		log.info("BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.info("AfterEach");
	}
	
	@Test
	@Disabled("for demonstration purposes")
	@EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
	void skippedTest() {
		log.info("not run");
		fail("Not yet implemented");
	}
			
	@Test
	@Order(4)
	@DisabledOnOs(OS.WINDOWS)
	void testFalse() {
		log.info("test Talse method");
		assertFalse(2==3);
	}
	
	@Test
	@Order(3)
	void testTrue() {	
		log.info("test True method");
		assertTrue(3==3);
	}
	
	@Test
	@RepeatedTest(10)
	@EnabledOnJre(JRE.JAVA_8)
	void onlyOnJava8() {
	    // ...
	}
	
	@Test
	@Order(2)
	@EnabledOnOs(OS.MAC)
	void testAdd() {
		log.info("test add method");	 
		assertEquals(300,compute.add(150,150));
	}
	
	@Test
	@Order(1)
	@EnabledOnOs(OS.WINDOWS)
	void testMinus() {
		log.info("test  minus method");	 
		assertEquals(150,compute.minus(300,150));
	}

	@Test
	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	void onlyOn64BitArchitectures() {
	    
	}

	@Test
	@DisabledIfSystemProperty(named = "ci-server", matches = "true")
	void notOnCiServer() {
	    
	}
	
	@Test
	@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
	void onlyOnStagingServer() {
	    // ...
	}

	@Test
	@DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
	void notOnDeveloperWorkstation() {
	    // ...
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
	  //  assertTrue(candidate);
	}
	
	@ParameterizedTest
	@CsvSource({
	        "滴滴,滴滴出行",
	        "alibaba,阿里巴巴",
	        "sougou,搜狗"
	})
	public void searchStocks(String searchInfo,String exceptName)   {
	   
	}
}
