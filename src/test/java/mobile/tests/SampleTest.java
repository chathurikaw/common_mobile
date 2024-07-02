package mobile.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import mobile.functions.BaseClass;

public class SampleTest extends BaseClass {

	AppiumDriver driver;

	@BeforeTest (description = "Launching the app and proceed to dashboard")
	public void launchApp() {
		driver = initializeDriver("config.properties");
	}

	@Test
	public void sampleTest() {
		System.out.println("Test");
	}

	@AfterTest
	public void closeApp() {
		//teardownDevice();
	}
}
