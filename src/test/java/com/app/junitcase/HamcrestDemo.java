package com.app.junitcase;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestDemo {
	@Test
	public void testEquals() {

		String theBiscuit = "name";
		String myBiscuit = "name";
		assertThat(theBiscuit, equalTo(myBiscuit));
	}
}