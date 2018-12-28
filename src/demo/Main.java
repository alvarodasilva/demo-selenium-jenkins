package demo;


import demo.Setup;
import org.openqa.selenium.WebDriver;

public class Main extends TestBase{

	public static void main(String[] args) throws Exception {
		
		//Configuración para ejecutar en Google Chrome
		WebDriver driver = Setup.lanchChrome();
		
		driver.get(Setup.ADMIN_URL);
		
		
		//Probando commit automatico
		
	}

}
