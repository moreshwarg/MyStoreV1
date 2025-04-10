package com.pomPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogin {
WebDriver driver;
@FindBy(xpath="(//*[text()='Account'])[1]")
WebElement accHeading;
@FindBy(xpath="(//*[text()='Login'])[1]")
WebElement accLogin;

@FindBy(xpath="//*[@id='accountFrm']/fieldset/button")
WebElement continueButton;

@FindBy(xpath="//*[@id='loginFrm_loginname']")
WebElement LoginName;

@FindBy(xpath="//*[@id='loginFrm_password']")
WebElement pass;

@FindBy(xpath="//*[@title='Login']")
WebElement loginButton;

public AccountLogin(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void accLoginMenu() {
	Actions act= new Actions(driver);
	act.moveToElement(accHeading).click(accLogin).build().perform();
}
public void continueButton() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy", 500);
	continueButton.click();
}
public void enterinLoginName(String uname) {
	LoginName.sendKeys(uname);	
}
public void enterinLoginPass(String pas) {
	pass.sendKeys(pas);
	loginButton.click();
	
}
}
