package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConst{
	
	public WebDriver driver;
	
	@BeforeMethod
	public void openBrowser(){
		
		//Open the browser
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver = new FirefoxDriver(); 
		
		//Synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter url  http://sydneytesters.herokuapp.com/
		driver.get("http://sydneytesters.herokuapp.com/");
	}
	
	@AfterMethod
	public void closeBrowser(){
		
		//Close the browser
		driver.quit();
	}
	

}