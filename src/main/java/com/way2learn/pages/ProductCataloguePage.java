package com.way2learn.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2learn.AbstractComponents.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	By spinner = By.cssSelector("ngx-spinner-overlay");
	By cartPageBtn = By.cssSelector("[routerlink*='cart']");
	
	@FindBy(css = ".mb-3")
	List<WebElement> items;
	
	public List<WebElement> getProductList() {
		return items;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod = items.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
		
	}
	
	public void goToCart() {
		
		waitForElementToBeClickable(cartPageBtn).click();
	}

}
