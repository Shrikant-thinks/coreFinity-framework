package com.way2learn.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.way2learn.base.BaseTest;
import com.way2learn.pages.CartPage;
import com.way2learn.pages.CheckOutPage;
import com.way2learn.pages.ConfirmationPage;
import com.way2learn.pages.ProductCataloguePage;

public class SubmitOrderTest extends BaseTest{
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
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
	}

}
