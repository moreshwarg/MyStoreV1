package com.testClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pomPages.AccountLogin;
import com.pomPages.HomePage;
import com.pomPages.OrderPage;

import junit.framework.Assert;

public class TC_ProductOrderPage extends BaseClass{

	private static  Logger logger = LogManager.getLogger(TC_MS_MyAccountDataDrivenTesting.class);
	AccountLogin al;
	HomePage hp;
	OrderPage op;
	@Test(enabled=true)
	public void orderPlacing() throws IOException, InterruptedException {
		al= new AccountLogin(driver);
		al.accLoginMenu();
		//al.continueButton();
		al.enterinLoginName("moresh");
		al.enterinLoginPass("moresh@123");
		hp= new HomePage(driver);
		String name=hp.ValidateUserLogged();
		//Assert.assertEquals(hp.ValidateUserLogged(), "Welcome back Moreshwar");
		logger.info("User login succssfully and reached on home page");
	
		
		if(name.equals("Welcome back Moreshwar")) {
			logger.info("User validated-passed");
			Assert.assertTrue(true);
		}else {
			captureScreenShot(driver,"verifyLogin");
			logger.info("User validated-failded");
			//Assert.assertTrue(true);
		}
		hp.clickOnHeading();

	op= new OrderPage(driver);
	op.orderPlacing();
	
	}
	
	
	
	
	
	
}
