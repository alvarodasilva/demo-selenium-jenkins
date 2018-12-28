package demo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Setup {
	public static String APP_URL = "https://katalon-demo-cura.herokuapp.com";
	public static String BLOG_URL = APP_URL + "/";
	public static String ADMIN_URL = APP_URL + "/profile.php#login";
	public static String USER = "John Doe";
	public static String PASSWORD = "ThisIsNotAPassword";
	
	private static String ROOT_DIR = System.getProperty("user.dir") 
			+ File.separator;
	
	private static String DRIVERS_DIR = ROOT_DIR
			+ "drivers"
			+ File.separator;
	
	private static String GECKO_PATH = DRIVERS_DIR 
			+ modifyIFWindows("geckodriver");
	
	private static String CHROME_PATH = DRIVERS_DIR
			+ modifyIFWindows("chromedriver");
	
	private static String FILES_DIR = ROOT_DIR 
			+ File.separator 
			+ "Files" 
			+ File.separator;
	
	private static String SCREENSHOTS_DIR = ROOT_DIR + "screenshots" + File.separator;
	
	public static WebDriver lanchFirefox() {
		System.setProperty("webdriver.gecko.driver", GECKO_PATH);
		return new FirefoxDriver();
	}
	
	public static WebDriver lanchChrome() {
		System.setProperty("webdriver.chrome.driver", CHROME_PATH);
		return new ChromeDriver();
	}
	
	private static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("win"); 
	}
	
	
	private static String modifyIFWindows(String inName) {
		if(isWindows()){
			return inName + ".exe";
		}
		else {
			return inName;
		}
	}
	
	public static String getScreenshotFilePathFor(String name) {
		String updateName = String.format("%s-%s.png", System.currentTimeMillis(),name);
		return SCREENSHOTS_DIR + updateName;
	}
}
