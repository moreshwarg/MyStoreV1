package com.testClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pomPages.AccountLogin;
import com.pomPages.CreateAccount;
import com.pomPages.HomePage;

import junit.framework.Assert;

public class TC_MS_MyAccountDataDrivenTesting extends BaseClass{
	private static  Logger logger = LogManager.getLogger(TC_MS_MyAccountDataDrivenTesting.class);
	AccountLogin al;
	HomePage hp;
	@Test(enabled=true)
	public void createAccountPage() throws InterruptedException {
		al= new AccountLogin(driver);
		al.accLoginMenu();
		al.continueButton();
		
		CreateAccount	 ca=new CreateAccount(driver);
		 ca.entringName("Moreshwar", "Gayke", "moreshgayk@gmail.com", "Mumbai", "Navi Mumbai");
		 ca.selectCountry();
		 Thread.sleep(2000);
		 ca.selectState();
	
		 Thread.sleep(2000);
		 ca.entringLoginCred("Moresh", "moresh@123", "moresh@123");
		 Thread.sleep(2000);

	}
	@Test(enabled=true)
	
	public void verifyLogin() throws IOException {
		al= new AccountLogin(driver);
		al.accLoginMenu();
		//al.continueButton();
		al.enterinLoginName("moresh");
		al.enterinLoginPass("moresh@123");
		hp= new HomePage(driver);
		String name=hp.ValidateUserLogged();
		//Assert.assertEquals(hp.ValidateUserLogged(), "Welcome back Moreshwar");
		logger.info("User login succssfully and reached on home page");
	
		
		if(name.equals("Welcome back Moreshwa")) {
			logger.info("User validated-passed");
			Assert.assertTrue(true);
		}else {
			captureScreenShot(driver,"verifyLogin");
			logger.info("User validated-failded");
			Assert.assertTrue(false);
		}
	}
	
}
