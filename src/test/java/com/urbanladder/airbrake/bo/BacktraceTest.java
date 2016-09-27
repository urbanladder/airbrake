package com.urbanladder.airbrake.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.urbanladder.airbrake.bo.Backtrace.Line;

/**
 * Tests for Backtrace model
 * 
 * @author salonegupta@gmail.com
 *
 */
public class BacktraceTest {

	@Test
	public void testInstantiation() {
		NumberFormatException exception = new NumberFormatException();
		Backtrace backtrace = new Backtrace(exception.getStackTrace());

		assertTrue(backtrace.getLines().size() > 0);

		Line line = backtrace.getLines().get(0);
		assertEquals("BacktraceTest.java", line.getFile());
		assertEquals("testInstantiation", line.getFunction());
	}

	@Test
	public void testDefaultInstantiation() {
		Backtrace backtrace = new Backtrace();
		assertEquals(0, backtrace.getLines().size());
	}
}
