package pom;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.TestException;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class getQuotePage1 {

	public WebDriver driver;

	//Declaration of elements on page1

	@FindBy(id="getlifequote")
	private WebElement lifeQuote;

	@FindBy(xpath="//h3[contains(.,'Sydney Testers Insurance')]")
	private WebElement textMsg1;

	//Initialization of elements on page1

	public getQuotePage1(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//clicking on 'Get Life Quote' button

	public void clickGetLifeQuote(){		
		lifeQuote.click();
	}

	//Checking the text message

	public void verifyTextMsg(){
		
		if(textMsg1.getText().equals("Sydney Testers Insurance"))
			Reporter.log("Text displayed correctly at page1", true);
		else
			Reporter.log("Text not displayed correctly at page1", true);
	}

	//verifying title of webpage
	
	public void verifyTitle(SoftAssert s){

		try{
			WebDriverWait wait = new WebDriverWait(driver,10);

			wait.until(ExpectedConditions.titleContains("QuickQuote"));
			Reporter.log("Title displayed correctly as: Sydney Testers QuickQuote on Page1",true);
		}
		catch(TestException e){
			Reporter.log("Title has not displayed correctly on Page1",true);
			s.fail();
		}


	}
}
