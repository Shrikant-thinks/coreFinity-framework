package com.way2learn;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.id("userEmail")).sendKeys("shrikantnair80@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shaddy@0120");
		driver.findElement(By.id("login")).click();
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
		System.out.println(items.size());
		WebElement prod = items.stream().filter(product->product.findElement(By.cssSelector("b")).
				getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		System.out.println();
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	  

	}

}
