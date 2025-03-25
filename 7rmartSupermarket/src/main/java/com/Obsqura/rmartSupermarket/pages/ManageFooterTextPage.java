package com.Obsqura.rmartSupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	WebElement action1;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressfield;
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailfield;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonenumfield;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebutton;

	

	public ManageFooterTextPage clickOnAction() {
		action1.click();
		return this;
	}

	public ManageFooterTextPage enterFooterDetails(String address, String email,String phonenum) {
		addressfield.sendKeys(address);
		emailfield.sendKeys(email);
		phonenumfield.sendKeys(phonenum);
		return this;
	}

	public ManageFooterTextPage clickOnUpdate() {
		updatebutton.click();
		return this;
	}

}
