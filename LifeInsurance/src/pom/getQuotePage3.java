package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.TestException;
import org.testng.asserts.SoftAssert;

public class getQuotePage3 {
	WebDriver driver;

	SoftAssert s = new SoftAssert();
	//Declaration of elements on page3
	
	@FindBy(xpath="//h3[contains(.,'Sydney Testers Life Insurance')]")
	private WebElement textMsg3;

	@FindBy(xpath="//*[@id='premiumResultform']/div[1]/dl/dd")
	private WebElement getQuoteValue;


	//Initialization of elements on page3
	
	public getQuotePage3(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Checking the text message
	
		public void verifyTextMsg(){
			
			if(textMsg3.getText().equals("Sydney Testers Insurance"))
				Reporter.log("Text displayed correctly at page3", true);
			else
				Reporter.log("Text not displayed correctly at page3", true);
		}

	//getting quote value

	public String getQuoteDisplayed(){

		String quote = getQuoteValue.getText();
		return (quote);		

	}

	//verifying title of webpage
	public void verifyTitle(SoftAssert s){

		try{
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.titleContains("QuickQuote"));
		Reporter.log("Title displayed correctly as: Sydney Testers QuickQuote on page3",true);
		}
		catch(TestException e){
			Reporter.log("Title has not displayed correctly on page3",true);
			s.fail();
		}
		
	}

}
