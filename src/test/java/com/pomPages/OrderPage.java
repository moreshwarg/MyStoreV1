package com.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class OrderPage {

	@FindBy(xpath="//*[@id='maincontainer']/div/div/div/div/div[3]/div[3]/div[2]/a/img")
	WebElement shirticon;
	
	@FindBy(xpath="//*[@id='product']/fieldset/div[6]/ul/li/a")
	WebElement addTOCart;
	
	@FindBy(xpath="//*[@id='cart_checkout1']")
	WebElement checkOut;
	
	@FindBy(xpath="//*[@id='checkout_btn']")
	WebElement confirmOrder;
	
	@FindBy(xpath="//*[@id='maincontainer']/div/div/div/h1/span[1]")
	WebElement validateOrderSucessmsg;
	
	// Your Order Has Been Processed!
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void orderPlacing() throws InterruptedException {
		shirticon.click();
		addTOCart.click();
		checkOut.click();
		confirmOrder.click();
	String valSucmsg=	validateOrderSucessmsg.getText();
	
	
	
	if(valSucmsg.contains("Your Order Has Been Processed!")) {
		System.out.println("Order placed successfully");
		Thread.sleep(2000);
		Assert.assertEquals(valSucmsg, "Your Order Has Been Processed!");
	}else {
		Thread.sleep(2000);
	//System.out.println("Order not placed");
		
	}
		
		
	}

}
