package com.urbanladder.airbrake.service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.urbanladder.airbrake.utils.Constants;

/**
 * To communicate about Airbrake to airbrake.io server
 * 
 * @author salonegupta@gmail.com
 *
 */
public class AirbrakeClient {

	private HttpURLConnection connection;

	public AirbrakeClient(String key, String projectId, String url, Map<String, String> options)
			throws MalformedURLException, IOException {
		String targetUrl = url.replace(Constants.PROJECT_ID, projectId).replace(Constants.API_KEY, key);
		connection = (HttpURLConnection) new URL(targetUrl).openConnection();

		if (options.containsKey(Constants.READ_TIMEOUT_OPTION)) {
			connection.setReadTimeout(Integer.parseInt(options.get(Constants.READ_TIMEOUT_OPTION)));
		} else {
			connection.setReadTimeout(Constants.READ_TIMEOUT);
		}

		if (options.containsKey(Constants.OPEN_TIMEOUT_OPTION)) {
			connection.setReadTimeout(Integer.parseInt(options.get(Constants.OPEN_TIMEOUT_OPTION)));
		} else {
			connection.setConnectTimeout(Constants.OPEN_TIMEOUT);
		}

		connection.setRequestProperty("Content-type", "application/json");
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
	}

	public int send(String notification) throws IOException {
		System.out.println(notification);
		final OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		writer.write(notification);
		writer.flush();
		writer.close();

		return connection.getResponseCode();
	}
}
