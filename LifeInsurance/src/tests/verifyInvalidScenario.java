package tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.BaseTest;
import pom.getQuotePage1;
import pom.getQuotePage2;


public class verifyInvalidScenario extends BaseTest {
	
	@Test
	public void testVerifyInvalidScenario1() throws InterruptedException{
		
		SoftAssert s = new SoftAssert();
		
		
		//Verify Page1 Elements
		
		getQuotePage1 page1 = new getQuotePage1(driver);
		
		Thread.sleep(1000);
		page1.clickGetLifeQuote();
		
		//Verify Page2 elements
		
		getQuotePage2 page2 = new getQuotePage2(driver);	
		
		page2.setAge("abc");
		Thread.sleep(1000);
		page2.selectGender("female");
		Thread.sleep(1000);
		page2.getOccupation("Medium Risk");
		Thread.sleep(1000);
		page2.getState("Victoria");
		Thread.sleep(1000);
		page2.getEmail("abc@xyz.com");
		
		page2.verifyErrMsg1IsPresent(s);
		
			
		s.assertAll();	

	}
	
	@Test
	public void testVerifyInvalidScenario2() throws InterruptedException{
		
		SoftAssert s = new SoftAssert();
		
		
		//Verify Page1 Elements
		
		getQuotePage1 page1 = new getQuotePage1(driver);
		
		Thread.sleep(1000);
		page1.clickGetLifeQuote();
		
		//Verify Page2 elements
		
		getQuotePage2 page2 = new getQuotePage2(driver);	
		
		page2.setAge("32");
		Thread.sleep(1000);
		page2.selectGender("female");
		Thread.sleep(1000);
		page2.getOccupation("High Risk");
		Thread.sleep(1000);
		page2.getState("Victoria");
		Thread.sleep(1000);
		page2.getEmail(" ");
		Thread.sleep(1000);
		page2.verifyErrMsg3IsPresent(s);
		Thread.sleep(1000);
		
		s.assertAll();	

	}
	
	@Test
	public void testVerifyInvalidScenario3() throws InterruptedException{
		
		SoftAssert s = new SoftAssert();
		
		
		//Verify Page1 Elements
		
		getQuotePage1 page1 = new getQuotePage1(driver);
		
		Thread.sleep(1000);
		page1.clickGetLifeQuote();
		
		//Verify Page2 elements
		
		getQuotePage2 page2 = new getQuotePage2(driver);	
		
		page2.setAge("32");
		Thread.sleep(1000);
		page2.selectGender("female");
		Thread.sleep(1000);
		page2.getOccupation("Medium Risk");
		Thread.sleep(1000);
		page2.getState("Tasmania");
		Thread.sleep(1000);
		page2.getEmail("&");
		page2.verifyErrMsg3IsPresent(s);
		
			
		s.assertAll();	

	}


}
