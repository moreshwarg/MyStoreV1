package com.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(xpath="//*[text()='Welcome back Moreshwar']")
WebElement validateUsr;

@FindBy(xpath="//*[@id='categorymenu']/nav/ul/li[2]/a")
WebElement apearlsHeading;

@FindBy(xpath="//*[@id='categorymenu']/nav/ul/li[2]/div/ul[1]/li[2]/a")
WebElement tShirtOption;




WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public String ValidateUserLogged() {
	String text= validateUsr.getText();
	return text;
}
public void clickOnHeading() {
	Actions act= new Actions(driver);
	act.moveToElement(apearlsHeading).click(tShirtOption).build().perform();
}
}
