package com.way2learn.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2learn.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOutBtn;
	
	public Boolean verifyProductInCart(String productName) {
		
		Boolean match = cartItems.stream().anyMatch(cartItem->cartItem.getText().equals(productName));
		return match;
	}
	
	public CheckOutPage goToCheckOutPage() {
		
		checkOutBtn.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
	
	
	
}
