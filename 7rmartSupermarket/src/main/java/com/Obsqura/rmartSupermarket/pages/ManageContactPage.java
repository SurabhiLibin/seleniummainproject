package com.Obsqura.rmartSupermarket.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Obsqura.rmartSupermarket.utilities.WaitUtility;

public class ManageContactPage {
	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement actionbutton;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement phonefield;
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailfield;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressfield;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliverytimefield;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliverychargelimit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebutton;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement resetbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;

	public ManageContactPage clickOnAction() {
		// waitutility.elementToBeClickable(driver, actionbutton);
		actionbutton.click();
		return this;
	}

	public ManageContactPage enterPhonenum(String num) {
		phonefield.sendKeys(num);
		return this;
	}

	public ManageContactPage enterEmail(String email) {
		emailfield.sendKeys(email);
		return this;
	}

	public ManageContactPage enterAddress(String address) {
		addressfield.sendKeys(address);
		return this;
	}

	public ManageContactPage enterDelTime(String time) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,3000)");
		deliverytimefield.sendKeys(time);
		return this;
	}

	public ManageContactPage enterDelCharge(String Charge) {
		deliverychargelimit.sendKeys(Charge);
		return this;
	}

	public ManageContactPage clickOnUpdate() {
		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

}
