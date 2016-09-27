package com.urbanladder.airbrake.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.urbanladder.airbrake.bo.ErrorNotification;

/**
 * Acts as an interface to capture Airbrake configuration and sends a notify
 * request to airbrake.io.
 * 
 * @author salonegupta@gmail.com
 *
 */
public class AirbrakeNotifier {

	private static AirbrakeNotifier notifier;

	private AirbrakeBuilder builder;

	private AirbrakeClient client;

	private String apiUrl = "https://airbrake.io/api/v3/projects/$PROJECT_ID/notices?key=$API_KEY";

	private AirbrakeNotifier(String apiKey, String projectId, Map<String, String> options)
			throws MalformedURLException, IOException {
		builder = new AirbrakeBuilder();
		this.client = new AirbrakeClient(apiKey, projectId, apiUrl, options);

		notifier = this;
	}

	public static void initialize(String apiKey, String projectId) throws MalformedURLException, IOException {
		new AirbrakeNotifier(apiKey, projectId, new HashMap<>());
	}

	public static void initialize(String apiKey, String projectId, Map<String, String> options)
			throws MalformedURLException, IOException {
		if (options == null) {
			options = new HashMap<>();
		}

		new AirbrakeNotifier(apiKey, projectId, options);
	}

	public static AirbrakeNotifier getInstance() {
		if (notifier == null) {
			throw new RuntimeException("Airbrake Notifier must be initialized before get Instance call");
		}

		return notifier;
	}

	public void notify(String message) throws IOException {
		ErrorNotification notification = builder.build(message);
		notify(notification);
	}

	public void notify(String message, Throwable throwable) throws IOException {
		ErrorNotification notification = builder.build(message, throwable);
		notify(notification);
	}

	public void notify(String message, Throwable throwable, Map<String, String> session, Map<String, String> params,
			Map<String, String> environment) throws IOException {
		ErrorNotification notification = builder.build(message, throwable);
		notify(notification);
	}

	private int notify(ErrorNotification errorNotification) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return client.send(mapper.writeValueAsString(errorNotification));
	}
}
