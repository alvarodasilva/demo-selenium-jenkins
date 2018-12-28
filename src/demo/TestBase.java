package demo;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestBase {
	//Creacion de variables para utilizarlas en los metodos.
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	//Creacion de métodos 
	protected WebDriver getDriver() {
		return driver;
	}
	
	protected WebDriverWait getWait() {
		return wait;
	}
	
	@BeforeEach
	public void login() throws Exception {
		driver = Setup.lanchChrome();
		wait = new WebDriverWait(driver, 10);
		
		driver.get(Setup.ADMIN_URL);
		
		driver.manage().window().maximize();
		
		WebElement userTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("txt-username")));
		userTextBox.sendKeys(Setup.USER);
		
		WebElement userPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("txt-password")));
		userPassword.sendKeys(Setup.PASSWORD);
		
		userPassword.submit();
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu-toggle")));
		}catch(NoSuchElementException e){
			throw new Exception("Algo esta mal. ");
		}
	}

	@Test
	void test() throws Exception{
		
	}

}
