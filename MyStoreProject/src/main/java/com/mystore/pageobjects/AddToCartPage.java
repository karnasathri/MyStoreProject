package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	Action action = new Action();

	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(name = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;
	

	@FindBy(xpath = "//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMessag;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	@FindBy(xpath = "//iframe[@class='fancybox-iframe']")
	WebElement iframe;

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		action.type(quantity, quantity1);
	}

	public void selectSize(String size1) throws Throwable {
		action.selectByVisibleText(size1, size);
	}

	public void clickOnAddToCart() throws Throwable {
		//driver.switchTo().frame(iframe);
		action.click(getDriver(), addToCartBtn);
		addToCartBtn.click();
		
	}

	public boolean validateAddtoCart() throws Throwable {
		
	   // action.fluentWait(driver, addToCartMessag, 10);
		return action.isDisplayed(getDriver(), addToCartMessag);
	}

	public OrderPage clickOnCheckOut() throws Throwable {
		
		action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
        action.JSClick(getDriver(), proceedToCheckOutBtn);
		//action.fluentWait(driver, proceedToCheckOutBtn, 10);
		return new OrderPage();
	}

}
