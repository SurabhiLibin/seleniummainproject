package com.Obsqura.rmartSupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement newsmessagefield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public ManageNewsPage enterNewMessage(String message) {
		newbutton.click();
		newsmessagefield.sendKeys(message);
		savebutton.click();
		return this;
	}

	public boolean isalertdisplayed() {
		return alertmessage.isDisplayed();
	}
}
