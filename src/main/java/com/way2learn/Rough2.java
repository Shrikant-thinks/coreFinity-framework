package com.way2learn;

import java.time.Duration;
import java.util.List;
import org.testng.Assert;

import com.way2learn.pages.CartPage;
import com.way2learn.pages.CheckOutPage;
import com.way2learn.pages.ConfirmationPage;
import com.way2learn.pages.LandingPage;
import com.way2learn.pages.ProductCataloguePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough2 {

	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		LandingPage landingPage = new LandingPage(driver);
		ProductCataloguePage productCataloguePage = landingPage.loginApplication("shrikantnair80@gmail.com", "Shaddy@0120");
		productCataloguePage.getProductList();
		productCataloguePage.addToCart(productName);
		CartPage cartPage = productCataloguePage.goToCart();
		Boolean match = cartPage.verifyProductInCart(productName);
		Assert.assertTrue(match);
		Thread.sleep(5000);
		CheckOutPage checkOutPage = cartPage.goToCheckOutPage();
		checkOutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String cartMsg = confirmationPage.getCartMessage();
		Assert.assertTrue(cartMsg.equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	}

}
