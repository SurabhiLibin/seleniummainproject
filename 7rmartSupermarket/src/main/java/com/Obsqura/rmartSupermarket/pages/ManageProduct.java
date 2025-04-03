package com.Obsqura.rmartSupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProduct {

	public WebDriver driver;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchmenu;
	@FindBy(xpath = "//input[@placeholder='Product Code']")
	WebElement productcodefield;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchbutton;

	public ManageProduct clickOnSearchmenu() {
		searchmenu.click();
		return this;
	}

	public ManageProduct enterProductCode(String code) {
		productcodefield.sendKeys(code);
		return this;
	}

	public ManageProduct clickOnSearch() {
		searchbutton.click();
		return this;
	}

}
