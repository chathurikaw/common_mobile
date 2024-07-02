package mobile.functions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;

public class MobilePageBase {

	public static AppiumDriver driver;
	private static final Logger logger = LogManager.getLogger(MobilePageBase.class);
	
	public static boolean verifyElementIsDiaplayed(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.debug("Element is visible: {}", element);
		} catch (Exception e) {
			logger.error("Failed to locate element", e);
			e.printStackTrace();
		}
		return element.isDisplayed();
	}

	public static void clickElement(WebElement element) {
		try {
			element.click();
			logger.debug("Clicked on element: {}", element);
			Thread.sleep(5000);
		} catch (Exception e) {
			logger.error("Failed to click on element", e);
			e.printStackTrace();
		}
	}
	
	public static void enterText(WebElement element, String text) {
		try {
			element.sendKeys(text);
			logger.debug("Entered Text :{}: on element :{} ", text, element);
		} catch (Exception e) {
			logger.error("Failed to enter text on element :{}",element ,e);
			e.printStackTrace();
		}
	}
	
	
	    }

