package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.TestException;
import org.testng.asserts.SoftAssert;


public class getQuotePage2 {
	public WebDriver driver;

	//Declaration of elements on page2

	@FindBy(id="age")
	private WebElement agE;

	@FindBy(xpath ="//input[@id='female']")
	private WebElement genderF;

	@FindBy(xpath ="//input[@id='male']")
	private WebElement genderM;

	@FindBy(id="occupation")
	private WebElement occupationList;

	@FindBy(id="state")
	private WebElement stateList;

	@FindBy(id="email")
	private WebElement emailId;
	
	@FindBy(id="getquote")
	private WebElement clickBtn;

	@FindBy(xpath="//h3[contains(.,'Sydney Testers Life Insurance')]")
	private WebElement textMsg2;

	@FindBy(xpath="//small[contains(.,'The age is required')]")
	private WebElement errMsg1;

	@FindBy(xpath="//small[contains(.,'is required')]")
	private WebElement errMsg2;

	@FindBy(xpath="//small[contains(.,'not valid')]")
	private WebElement errMsg3;

	//Initialization of elements on page2

	public getQuotePage2(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Enter the details on elements

	public void setAge(String age){	
		
		agE.sendKeys(age);				
	}

	public void selectGender(String gender){

		if(gender.equalsIgnoreCase("Female"))
			genderF.click();
		else
			genderM.click();
	}

	public void getOccupation(String occupation){

		Select selOccupation = new Select(occupationList);
	
		selOccupation.selectByVisibleText(occupation);

	}

	public void getState(String state){

		Select selState = new Select(stateList);
		
		selState.selectByVisibleText(state);
	}

	public void getEmail(String email){

		emailId.sendKeys(email);
	}

	public void clickButton(){
		
		clickBtn.click();
	}
	
	//Checking the error messages

	public void verifyErrMsg1IsPresent(SoftAssert s){

		try{
			WebDriverWait wait = new WebDriverWait(driver,10);

			wait.until(ExpectedConditions.visibilityOf(errMsg1));
			Reporter.log("Error Message displayed correctly on Page2",true);
		}
		catch(TestException e){
			Reporter.log("Error Message has not displayed correctly on Page2",true);
			s.fail();
		}
	

	}

	public void verifyErrMsg2IsPresent(SoftAssert s){

		try{
			WebDriverWait wait = new WebDriverWait(driver,10);

			wait.until(ExpectedConditions.visibilityOf(errMsg2));
			Reporter.log("Error Message displayed correctly on Page2 for not providing email",true);
		}
		catch(TestException e){
			Reporter.log("Error Message has not displayed correctly on Page2 for not providing email",true);
			s.fail();
		}
	

	}
	
	public void verifyErrMsg3IsPresent(SoftAssert s){

		try{
			WebDriverWait wait = new WebDriverWait(driver,10);

			wait.until(ExpectedConditions.visibilityOf(errMsg3));
			Reporter.log("Error Message displayed correctly on Page2 for incorrect email",true);
		}
		catch(TestException e){
			Reporter.log("Error Message has not displayed correctly on Page2 for incorrect email",true);
			s.fail();
		}
	

	}

	//Checking the text message
	
	public void verifyTextMsg(){
		
		if(textMsg2.getText().equals("Sydney Testers Insurance"))
			Reporter.log("Text displayed correctly at page2", true);
		else
			Reporter.log("Text not displayed correctly at page2", true);
	}


	//verifying title of webpage

	public void verifyTitle(SoftAssert s){

		try{
			WebDriverWait wait = new WebDriverWait(driver,10);

			wait.until(ExpectedConditions.titleContains("QuickQuote"));
			Reporter.log("Title displayed correctly as: Sydney Testers QuickQuote on Page2",true);
		}
		catch(TestException e){
			Reporter.log("Title has not displayed correctly on Page2",true);
			s.fail();
		}

	}
	
}
