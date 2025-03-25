package com.Obsqura.rmartSupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public LoginPage enterusernameandpassword(String username, String password) {
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickonsignin() {
		signin.click();
		return new HomePage(driver);
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
