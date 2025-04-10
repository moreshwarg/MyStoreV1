package com.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
@FindBy(xpath="//*[@id='AccountFrm_firstname']")
WebElement fName;
@FindBy(xpath="//*[@id='AccountFrm_lastname']")
WebElement lName;
@FindBy(xpath="//*[@id='AccountFrm_email']")
WebElement email;
@FindBy(xpath="//*[@id='AccountFrm_address_1']")
WebElement addr1;
@FindBy(xpath="//*[@id='AccountFrm_city']")
WebElement city;
@FindBy(xpath="//*[@id='AccountFrm_zone_id']")
WebElement state;
@FindBy(xpath="//*[@id='AccountFrm_postcode']")
WebElement zipCode;
@FindBy(xpath="//*[@id='AccountFrm_country_id']")
WebElement country;

@FindBy(xpath="//*[@id='AccountFrm_loginname']")
WebElement loginName;
@FindBy(xpath="//*[@id='AccountFrm_password']")
WebElement pas;
@FindBy(xpath="//*[@id='AccountFrm_confirm']")
WebElement confirmPass;

@FindBy(xpath="//*[@id='AccountFrm_agree']")
WebElement pricacyButton;
@FindBy(xpath="//*[@id='AccountFrm']/div[5]/div/div/button")
WebElement continueButtons;

WebDriver driver;
public CreateAccount(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void entringName(String fname,String lnam ,String emai,String ddr1, String cit) {
	fName.sendKeys(fname);
	lName.sendKeys(lnam);
	email.sendKeys(emai);
	addr1.sendKeys(ddr1);
	city.sendKeys(cit);
}
public void selectState() {
	Select s= new Select(state);
	s.selectByVisibleText("Maharashtra");
	zipCode.sendKeys("123456");
}
public void selectCountry() {
	Select s= new Select(country);
	s.selectByVisibleText("India");
}
public void entringLoginCred(String ln,String pa,String cnpass) {
	loginName.sendKeys(ln);
	pas.sendKeys(pa);
	confirmPass.sendKeys(cnpass);
	pricacyButton.click();
	continueButtons.click();
	
}
}
