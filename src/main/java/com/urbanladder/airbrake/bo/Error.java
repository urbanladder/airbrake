package com.urbanladder.airbrake.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * To capture Java error details like error type, message and stacktrace
 * 
 * @author salonegupta@gmail.com
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class Error {

	private String type;

	private String message;

	@JsonUnwrapped
	private Backtrace backtrace;

	public Error(String message) {
		this.type = "Exception";
		this.message = message;
		this.backtrace = new Backtrace();
	}

	public Error(Throwable throwable) {
		this.message = throwable.getMessage();
		this.type = throwable.getClass().getSimpleName();
		this.backtrace = new Backtrace(throwable.getStackTrace());
	}

	public Error(String message, Throwable throwable) {
		this.message = message + ". " + throwable.getMessage();
		this.type = throwable.getClass().getSimpleName();
		this.backtrace = new Backtrace(throwable.getStackTrace());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Backtrace getBacktrace() {
		return backtrace;
	}

	public void setBacktrace(Backtrace backtrace) {
		this.backtrace = backtrace;
	}

	@Override
	public String toString() {
		return "Error [type=" + type + ", message=" + message + ", backtrace=" + backtrace + "]";
	}

}
