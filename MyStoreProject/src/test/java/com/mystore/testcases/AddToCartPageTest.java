package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);
	}
	
	/*
	 * @AfterMethod public void tearDown() { driver.quit();
	 */
   //	}
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest() throws Throwable {
		index = new IndexPage();
		searchresultpage =index.searchProduct("t-shirt");
		searchresultpage.clickOnProduct();
		Thread.sleep(3000);
		addToCartPage = searchresultpage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		Thread.sleep(3000);
		addToCartPage.clickOnAddToCart();
	   // boolean result = addToCartPage.validateAddtoCart();
	    //Assert.assertTrue(result);
	    
	}

}
