package com.urbanladder.airbrake.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for Error model
 * 
 * @author salonegupta@gmail.com
 *
 */
public class ErrorTest {

	@Test
	public void testIntantiationWithException() {
		NumberFormatException exception = new NumberFormatException();
		Error error = new Error(exception);

		assertNotNull(error.getBacktrace());
		assertEquals("NumberFormatException", error.getType());
		assertNull(error.getMessage());
	}

	@Test
	public void testIntantiationWithExceptionWithMessage() {
		String exceptionMessage = "Error is fetching details";
		RuntimeException exception = new RuntimeException(exceptionMessage);
		Error error = new Error(exception);

		assertNotNull(error.getBacktrace());
		assertEquals("RuntimeException", error.getType());
		assertEquals(exceptionMessage, error.getMessage());
	}

	@Test
	public void testIntantiationWithMessage() {
		String errorMessage = "Error in evaluating an expression";
		Error error = new Error(errorMessage);

		assertTrue(error.getBacktrace().getLines().isEmpty());
		assertEquals("Exception", error.getType());
		assertEquals(errorMessage, error.getMessage());
	}

	@Test
	public void testIntantiationWithExceptionAndMessage() {
		String exceptionMessage = "Error in fetching details";
		Exception exception = new Exception(exceptionMessage);
		String errorMessage = "Error in evaluating an expression";
		Error error = new Error(errorMessage, exception);

		String exceptedMessage = errorMessage + ". " + exceptionMessage;
		assertNotNull(error.getBacktrace());
		assertEquals("Exception", error.getType());
		assertEquals(exceptedMessage, error.getMessage());
	}
}
