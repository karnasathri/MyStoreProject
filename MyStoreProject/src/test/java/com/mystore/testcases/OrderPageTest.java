package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);
	}
	
	
	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */
	@Test(groups = "Regression")
	public void verifyTotalPrice() throws Throwable {
		index = new IndexPage();
		searchresultpage =index.searchProduct("t-shirt");
		searchresultpage.clickOnProduct();
		addToCartPage = searchresultpage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalDExpectedPrice = (unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalDExpectedPrice);
		
		
		
	}

}
