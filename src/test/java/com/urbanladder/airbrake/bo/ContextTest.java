package com.urbanladder.airbrake.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.net.InetAddress;

import org.junit.Test;

/**
 * Tests for Context model
 * 
 * @author salonegupta@gmail.com
 *
 */
public class ContextTest {

	@Test
	public void testInstantiation() throws Exception {
		Context context = new Context();

		assertNull(context.getEnvironment());
		assertNull(context.getNotifier());
		assertNull(context.getRootDirectory());
		assertNull(context.getUrl());
		assertNull(context.getUser());
		assertNull(context.getUserAgent());
		assertNull(context.getVersion());

		String hostname = InetAddress.getLocalHost().getHostName();
		assertEquals(hostname, context.getHostname());

		String javaVersion = System.getProperty("java.runtime.version");
		String javaVendor = System.getProperty("java.vm.vendor");
		String language = "Java " + javaVersion + " (" + javaVendor + ")";
		assertTrue(context.getLanguage().contains(language));

		assertEquals(System.getProperty("os.name"), context.getOs());
	}
}
