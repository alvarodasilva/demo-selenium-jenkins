package demo;


import demo.Setup;
import org.openqa.selenium.WebDriver;

public class Main extends TestBase{

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = Setup.lanchChrome();
		
		driver.get(Setup.ADMIN_URL);
		
	}

}
