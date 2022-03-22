package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	Log log;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);
	}
	
	/*
	 * @AfterMethod() public void tearDown() { driver.quit(); }
	 */

	
	@Test(dataProvider = "Credentials1", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"} )
	public void loginTest(String uname,String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		Thread.sleep(5000);
		indexPage = new IndexPage();
		Log.info("user is going to click on signIn");
		Thread.sleep(5000);
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), homePage);
		Thread.sleep(5000);
		homePage = loginPage.login(uname,pswd,homePage);
		Thread.sleep(5000);
		String actualURL = homePage.getCurrentURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verofying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Thread.sleep(5000);
		Log.info("Login is sucess");
		Log.endTestCase("loginTest");
	}

}
