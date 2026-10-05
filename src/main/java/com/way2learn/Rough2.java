package com.way2learn;

import java.time.Duration;
import java.util.List;
import org.testng.Assert;

import com.way2learn.pages.CartPage;
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

	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication("shrikantnair80@gmail.com", "Shaddy@0120");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(".mb-3")));
		ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
		List<WebElement> items = productCataloguePage.getProductList();
		productCataloguePage.addToCart(productName);
		productCataloguePage.goToCart();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.verifyProductInCart(productName);
		Assert.assertTrue(match);
		cartPage.goToCheckOutPage();
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String cartMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();	
		Assert.assertTrue(cartMsg.equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	}

}
