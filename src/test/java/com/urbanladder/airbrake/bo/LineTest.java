package com.urbanladder.airbrake.bo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.urbanladder.airbrake.bo.Backtrace.Line;

/**
 * Tests for Backtrace Line model
 * 
 * @author salonegupta@gmail.com
 *
 */
public class LineTest {

	@Test
	public void testInstantiation() {
		Line line = new Line("LineTest.java", 1, "testInstantiation");
		assertEquals("LineTest.java", line.getFile());
		assertEquals(1, line.getLine());
		assertEquals("testInstantiation", line.getFunction());
	}
}
