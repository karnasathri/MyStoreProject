/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConformationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author admin
 *
 */
public class EndToEndTest extends BaseClass {
	
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummery;
	OrderConformationPage orderConformationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);
	}
	
	
	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */
	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable {
		index = new IndexPage();
		Thread.sleep(5000);
		searchresultpage =index.searchProduct("t-shirt");
		searchresultpage.clickOnProduct();
		addToCartPage = searchresultpage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		Thread.sleep(10000);
		orderPage = addToCartPage.clickOnCheckOut();
		Thread.sleep(5000);
		loginPage = orderPage.clickOnCheckOut();
		Thread.sleep(5000);
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		shippingPage = addressPage.clickOnCheckOut();
		Thread.sleep(5000);
		shippingPage.checkTheTerms();
		Thread.sleep(5000);
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		Thread.sleep(5000);
		orderSummery=paymentPage.clickOnPaymentMethod();
		Thread.sleep(5000);
		orderConformationPage=orderSummery.clickOnconfirmOrderBtn();
		Thread.sleep(5000);
		String actulMessage=orderConformationPage.validateConfirmMessage();
		Thread.sleep(5000);
		String expectedMsg="Your order on My Store is complete.";
		Thread.sleep(5000);
		Assert.assertEquals(actulMessage,expectedMsg );
		
		
		
		
	}

}
