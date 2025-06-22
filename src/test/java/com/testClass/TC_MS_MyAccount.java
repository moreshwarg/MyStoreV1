package com.testClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pomPages.AccountLogin;
import com.pomPages.CreateAccount;
import com.pomPages.HomePage;
import com.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MS_MyAccount extends BaseClass{
	private static  Logger logger = LogManager.getLogger(TC_MS_MyAccount.class);
	AccountLogin al;
	HomePage hp;
	@Test(enabled=false)
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
	@Test(enabled=false,dataProvider = "LoginDataProvider")	
	public void verifyLogin(String uname,String pwd,String expectedName) throws IOException {
		al= new AccountLogin(driver);
		al.accLoginMenu();
		//al.continueButton();
		al.enterinLoginName(uname);
		al.enterinLoginPass(pwd);
		hp= new HomePage(driver);
		//String name=hp.ValidateUserLogged();
	//	Assert.assertEquals(hp.ValidateUserLogged(), expectedName);
		logger.info("User login succssfully and reached on home page");
	
//		
//		if(name.equals("Welcome back Moreshwar")) {
//			logger.info("User validated-passed");
//			Assert.assertTrue(true);
//		}else {
//			captureScreenShot(driver,"verifyLogin");
//			logger.info("User validated-failded");
//			Assert.assertTrue(false);
//		}
	}
	//@DataProvider(name="loginDataProvider")
	//public String[][] loginDataProvider(){
		//String fileName=System.getProperty("C:\\Users\\Moreshwar\\Desktop\\MyStoreTestcases.xlsx");
		@DataProvider(name = "LoginDataProvider")
		public String[][] LoginDataProvider()
		{
			//System.out.println(System.getProperty("user.dir"));
			String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestcases.xlsx";


			int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
			int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
			String data[][]=new String[ttlRows-1][ttlColumns];

			for(int i=1;i<ttlRows;i++)//rows =1,2
			{
				for(int j=0;j<ttlColumns;j++)//col=0, 1,2
				{

					data[i][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
				}

			}
			return data;
		}
}
