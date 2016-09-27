package com.urbanladder.airbrake.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Error Notification class to capture Airbrake notice details
 * 
 * @author salonegupta@gmail.com
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class ErrorNotification {

	private List<Error> errors;

	private Context context;

	private Map<String, String> environment;

	private Map<String, String> session;

	private Map<String, String> params;

	public ErrorNotification() {
		this.context = new Context();
		this.errors = new ArrayList<>();
		this.session = new HashMap<>();
		this.params = new HashMap<>();
		this.environment = new HashMap<>();
	}

	public ErrorNotification(String message) {
		this();

		if (message != null && !message.isEmpty()) {
			Error error = new Error(message);
			errors.add(error);
		}
	}

	public ErrorNotification(String message, Throwable throwable) {
		this();

		Error error = new Error(message, throwable);
		errors.add(error);

		while (throwable.getCause() != null) {
			Error cause = new Error(throwable.getCause());
			errors.add(cause);
		}
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Map<String, String> getEnvironment() {
		return environment;
	}

	public void setEnvironment(Map<String, String> environment) {
		this.environment = environment;
	}

	public Map<String, String> getSession() {
		return session;
	}

	public void setSession(Map<String, String> session) {
		this.session = session;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "ErrorNotification [errors=" + errors + ", context=" + context + ", environment=" + environment
				+ ", session=" + session + ", params=" + params + "]";
	}

}
