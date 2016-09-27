package com.urbanladder.airbrake.bo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * To capture Airbrake context details like notifier, environment details, user
 * details etc.
 * 
 * @author salonegupta@gmail.com
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class Context {

	private Notifier notifier;

	private String os;

	private String hostname;

	private String language;

	private String environment;

	private String version;

	private String url;

	private String rootDirectory;

	private String userAgent;

	private User user;

	public Context() {
		this.os = System.getProperty("os.name");

		try {
			this.hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			this.hostname = "NA";
		}

		String javaVersion = System.getProperty("java.runtime.version");
		String javaVendor = System.getProperty("java.vm.vendor");
		this.language = "Java " + javaVersion + " (" + javaVendor + ")";
	}

	public Notifier getNotifier() {
		return notifier;
	}

	public void setNotifier(Notifier notifier) {
		this.notifier = notifier;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
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

	public String getRootDirectory() {
		return rootDirectory;
	}

	public void setRootDirectory(String rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Context [notifier=" + notifier + ", os=" + os + ", hostname=" + hostname + ", language=" + language
				+ ", environment=" + environment + ", version=" + version + ", url=" + url + ", rootDirectory="
				+ rootDirectory + ", user=" + user + "]";
	}

}
