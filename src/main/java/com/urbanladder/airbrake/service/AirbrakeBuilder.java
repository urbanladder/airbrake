package com.urbanladder.airbrake.service;

import java.util.Map;

import com.urbanladder.airbrake.bo.ErrorNotification;

/**
 * To build ErrorNotification object from a String message and a Throwable
 * object
 * 
 * @author salonegupta@gmail.com
 *
 */
public class AirbrakeBuilder {

	public ErrorNotification build(String message) {
		return new ErrorNotification(message);
	}

	public ErrorNotification build(String message, Throwable throwable) {
		return new ErrorNotification(message, throwable);
	}

	public ErrorNotification build(String message, Throwable throwable, Map<String, String> session,
			Map<String, String> params, Map<String, String> environment) {
		ErrorNotification notification = new ErrorNotification(message, throwable);
		notification.setSession(session);
		notification.setParams(params);
		notification.setEnvironment(environment);

		return notification;
	}
}
