
package com.app.junitcase;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputeTest {

	private static Compute compute;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		compute=new Compute();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.app.junitcase.Compute#add(int, int)}.
	 */
	@Test
	void testAdd() {
	//	fail("Not yet implemented"); 
		assertEquals(300,compute.add(150,150));
	}

}
