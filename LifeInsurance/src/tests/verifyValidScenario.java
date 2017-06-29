package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.getQuotePage1;
import pom.getQuotePage2;
import pom.getQuotePage3;
import generic.BaseTest;

public class verifyValidScenario extends BaseTest {
	
	@Test
	public void testVerifyValidScenario() throws InterruptedException{
		
		SoftAssert s = new SoftAssert();
		
		
		//Verify Page1 Elements
		
		getQuotePage1 page1 = new getQuotePage1(driver);
		
		page1.verifyTitle(s);
		Thread.sleep(1000);
		page1.verifyTextMsg();
		Thread.sleep(1000);
		page1.verifyTextMsg();
		Thread.sleep(1000);
		page1.verifyTitle(s);
		Thread.sleep(1000);
		page1.clickGetLifeQuote();
		
		//Verify Page2 elements
		
		getQuotePage2 page2 = new getQuotePage2(driver);	
		
		page2.verifyTitle(s);
		Thread.sleep(1000);
		page2.verifyTextMsg();
		Thread.sleep(1000);
		page2.setAge("32");
		Thread.sleep(1000);
		page2.selectGender("female");
		Thread.sleep(1000);
		page2.getOccupation("Medium Risk");
		Thread.sleep(1000);
		page2.getState("Victoria");
		Thread.sleep(1000);
		page2.getEmail("abc@xyz.com");
		Thread.sleep(1000);
		page2.clickButton();
		
		//Verify Page3 elements
		
		getQuotePage3 page3 = new getQuotePage3(driver);	
		
		page3.verifyTitle(s);
		Thread.sleep(1000);
		page3.verifyTextMsg();
		Thread.sleep(1000);
		String quote= page3.getQuoteDisplayed();
		
		Reporter.log("Quote for Sydney Testers Life Insurance is: "+quote, true);
		s.assertAll();
		
	}

}
