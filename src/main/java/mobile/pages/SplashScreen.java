package mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import mobile.functions.BaseClass;

public class SplashScreen extends BaseClass{

	public AppiumDriver driver;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"PROCEED TO DASHBOARD\"]")
	@CacheLookup
	WebElement btnProceedToDashboard;
	
	public SplashScreen(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void proceedToDashboard() {
		btnProceedToDashboard.click();
	}
}
