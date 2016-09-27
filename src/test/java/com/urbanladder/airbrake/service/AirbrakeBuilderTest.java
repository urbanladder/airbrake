package com.urbanladder.airbrake.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.urbanladder.airbrake.bo.Error;
import com.urbanladder.airbrake.bo.ErrorNotification;

/**
 * Tests for AirbrakeBuilder class
 * 
 * @author salonegupta@gmail.com
 *
 */
public class AirbrakeBuilderTest {

	@Test
	public void testBuild() {
		AirbrakeBuilder builder = new AirbrakeBuilder();
		ErrorNotification notification = builder.build("Error in fetching details",
				new Exception("Error in performing operation"));

		assertNotNull(notification.getContext());
		assertNotNull(notification.getEnvironment());
		assertNotNull(notification.getParams());
		assertNotNull(notification.getSession());

		List<Error> errors = notification.getErrors();
		assertNotNull(errors);
		assertFalse(errors.isEmpty());
		assertEquals(errors.size(), 1);
	}

	@Test
	public void testBuildWithMessage() {
		AirbrakeBuilder builder = new AirbrakeBuilder();
		ErrorNotification notification = builder.build("Error in fetching details");

		assertNotNull(notification.getContext());
		assertNotNull(notification.getEnvironment());
		assertNotNull(notification.getParams());
		assertNotNull(notification.getSession());

		List<Error> errors = notification.getErrors();
		assertNotNull(errors);
		assertFalse(errors.isEmpty());
		assertEquals(errors.size(), 1);
	}

	@Test
	public void testBuildWithParams() {
		AirbrakeBuilder builder = new AirbrakeBuilder();

		Map<String, String> params = new HashMap<>();
		Map<String, String> session = new HashMap<>();
		Map<String, String> environment = new HashMap<>();
		params.put("param1", "value1");
		session.put("sparam1", "svalue1");
		environment.put("eparam1", "evalue1");

		ErrorNotification notification = builder.build("Error in fetching details",
				new Exception("Error in performing operation"), session, params, environment);

		assertNotNull(notification.getContext());
		assertEquals("value1", notification.getParams().get("param1"));
		assertEquals("svalue1", notification.getSession().get("sparam1"));
		assertEquals("evalue1", notification.getEnvironment().get("eparam1"));

		List<Error> errors = notification.getErrors();
		assertNotNull(errors);
		assertFalse(errors.isEmpty());
		assertEquals(errors.size(), 1);
	}
}
