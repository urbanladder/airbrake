package com.urbanladder.airbrake.utils;

/**
 * To capture system wide constants
 * 
 * @author salonegupta@gmail.com
 *
 */
public interface Constants {

	int READ_TIMEOUT = 10 * 1000;
	int OPEN_TIMEOUT = 10 * 1000;

	String READ_TIMEOUT_OPTION = "READ_TIMEOUT";
	String OPEN_TIMEOUT_OPTION = "OPEN_TIMEOUT";

	String PROJECT_ID = "$PROJECT_ID";
	String API_KEY = "$API_KEY";
}
