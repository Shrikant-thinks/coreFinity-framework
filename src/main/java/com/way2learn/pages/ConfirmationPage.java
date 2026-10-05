package com.way2learn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2learn.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//String cartMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();	
	
	@FindBy(css = ".hero-primary")
	WebElement cartMsgElement;
	
	public String getCartMessage() {
		
		return cartMsgElement.getText();
	}

}
