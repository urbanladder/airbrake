package com.urbanladder.airbrake.bo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for Notifier model
 * 
 * @author salonegupta@gmail.com
 *
 */
public class NotifierTest {

	@Test
	public void testInstantiation() {
		Notifier notifier = new Notifier();

		assertEquals("Airbrake Client", notifier.getName());
		assertEquals("https://www.urbanladder.com", notifier.getUrl());
		assertEquals("1.0.0", notifier.getVersion());
	}
}
