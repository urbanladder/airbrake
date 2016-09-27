package com.urbanladder.airbrake.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

/**
 * Tests for ErrorNotification model
 * 
 * @author salonegupta@gmail.com
 *
 */
public class ErrorNotificationTest {

	@Test
	public void testInstantiation() {
		ErrorNotification notification = new ErrorNotification("Error while fetching details");

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
	public void testInstantiationWithParams() {
		ErrorNotification notification = new ErrorNotification("Error while fetching details");
		notification.getParams().put("param1", "value1");
		notification.getSession().put("sparam1", "svalue1");
		notification.getEnvironment().put("eparam1", "evalue1");

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
