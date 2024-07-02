package mobile.functions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	 private static Properties properties = new Properties();

	    static {
	        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
	            if (input == null) {
	                System.out.println("Sorry, unable to find config.properties");
	               
	            }
	            properties.load(input);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public static String getPlatformName() {
	        return properties.getProperty("platformName");
	    }
	    
	    public static String getAutomationName() {
	        return properties.getProperty("automationName");
	    }
	    
	    public static String getDeviceName() {
	        return properties.getProperty("deviceName");
	    }
	    
	    public static String getApp() {
	        return properties.getProperty("app");
	    }
	    
	    public static String GetAppPackageName() {
	        return properties.getProperty("appPackageName");
	    }
	   
	    public static String getAppActivity() {
	        return properties.getProperty("appActivity");
	    }
	    
	    public static String getAppiumURL() {
	        return properties.getProperty("appiumURL");
	    }
}
