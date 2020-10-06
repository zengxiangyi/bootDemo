package com.app.junitcase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SimpleAssertionsExample {

	@Test
	void a_few_simple_assertions() {
		assertThat("The Lord of the Rings").isNotNull().startsWith("The").contains("Lord").endsWith("Rings");
	}

}