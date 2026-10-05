package com.way2learn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2learn.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
	By countryList = By.cssSelector(".ta-results");
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryInfoEle;
	
	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	@FindBy(css = "action__submit")
	WebElement submitBtn;
	
	public void selectCountry(String countryName) {
		countryInfoEle.sendKeys(countryName);
		waitForElementToAppear(countryList);
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		
		submitBtn.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
		
	}
	
	

}
