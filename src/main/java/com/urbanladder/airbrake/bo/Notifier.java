package com.urbanladder.airbrake.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * To capture appliaction details who is raising an Airbrake
 * 
 * @author salonegupta@gmail.com
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class Notifier {

	private String name = "Airbrake Client";

	private String version = "1.0.0";

	private String url = "https://www.urbanladder.com";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Notifier [name=" + name + ", version=" + version + ", url=" + url + "]";
	}

}
