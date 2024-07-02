package mobile.functions;

import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class BaseClass{

	public static AndroidDriver driver;
	private static final Logger logger = LogManager.getLogger(BaseClass.class);
	
	public static AppiumDriver initializeDriver(String configFilePath) {
		
		try {
			URL appiumURL = new URL("http://192.168.56.1:4723/");
			driver = new AndroidDriver(appiumURL,setCapabilitiesAndroid());
			if (driver.isAppInstalled(Config.GetAppPackageName())) { 
				logger.debug("App Installed Successfully");
            } else {
            	logger.debug("App Installation Failed");
            }	
			} catch (Exception e) {
				logger.error("Failed to install App", e);
		}	
		return driver;
	}
	
	public static DesiredCapabilities setCapabilitiesAndroid() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", Config.getPlatformName());		
		capabilities.setCapability("appium:automationName", Config.getAutomationName());
		capabilities.setCapability("appium:deviceName", Config.getDeviceName());
		capabilities.setCapability("appium:app", Config.getApp());	
		capabilities.setCapability("appium:appPackage", Config.GetAppPackageName());
		capabilities.setCapability("appium:appActivity", Config.getAppActivity());
		logger.debug("Desired Capabilities : {}",capabilities);
		return capabilities;
	}
	
	
	public static void teardownDevice() {
		logger.debug("Tearing down device...");
		if (driver != null) {
            driver.quit();
        }
	}
	
//	public static void scrollDown() {
//		Dimension size = driver.manage().window().getSize();
//		System.out.print(size);
//		Point midPoint = new Point((int)(size.width*0.5),(int)( size.height*0.5));
//		int bottom = midPoint.y + (int)(midPoint.y*0.75);
//		int top = midPoint.y - (int)(midPoint.y*0.75);
//		Point start = new Point(midPoint.x, bottom);
//		Point end = new Point(midPoint.x, top);
//			swipe(start, end);
//	}
//
//	private static void swipe(Point start, Point end){
//		try {
//		PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "touch");
//		Sequence swipe = new Sequence(pointer ,0);
//		swipe.addAction(pointer.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
//		swipe.wait(3000);
//		swipe.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//		swipe.wait(3000);
//		swipe.addAction(pointer.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), end.x, end.y));
//		swipe.wait(3000);
//		swipe.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//		swipe.wait(3000);
//		driver.perform(ImmutableList.of(swipe));
//		driver.
//	} 
//		catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
	
	
}
