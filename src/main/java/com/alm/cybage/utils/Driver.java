package com.alm.cybage.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

	protected static WebDriver driver;

	public static void getDriver() {
		String os = System.getProperty("os.name");
		String osarch = System.getProperty("os.arch");
		System.out.println("OS= " + os + " Arch= " + osarch);

		if ("Windows 7".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"src/test/resources/phantomjs.exe");
			driver = new PhantomJSDriver(capabilities);
		} else if ("Windows 8".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"src/test/resources/phantomjs.exe");
			driver = new PhantomJSDriver(capabilities);
		} else if ("Linux".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"src/test/resources/phantomjs");
			driver = new PhantomJSDriver(capabilities);
		}
	}

}
