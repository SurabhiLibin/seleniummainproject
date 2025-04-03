package com.Obsqura.rmartSupermarket.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Obsqura.rmartSupermarket.utilities.PageUtility;
import com.Obsqura.rmartSupermarket.utilities.WaitUtility;

public class SettingsPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement buttonnew;
	@FindBy(xpath = "//input[@name='name']")
	WebElement menunamefield;
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement parentmenufield;
	@FindBy(xpath = "//input[@name='menu_table']")
	WebElement tablenamemenu;
	@FindBy(xpath = "//input[@name='color']")
	WebElement colorfield;
	@FindBy(xpath = "(//input[@name='set_home'])[1]")
	WebElement radiobutton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public SettingsPage clickOnNew() {
		buttonnew.click();
		return this;
	}

	public SettingsPage enterMenuName(String name) {
		menunamefield.sendKeys(name);
		return this;
	}

	public SettingsPage enterParentMenu(String parent) {
		Select select = new Select(parentmenufield);
		select.selectByVisibleText(parent);
		return this;
	}

	public SettingsPage enterTableName(String tablename) {
		tablenamemenu.sendKeys(tablename);
		return this;
	}

	public SettingsPage enterColor(String color) {
		colorfield.sendKeys(color);
		return this;
	}

	public SettingsPage clickOnRadiobutton() {
		pageutility.javaScriptExecutor(driver, radiobutton);
		waitutility.elementToBeClickable(driver, radiobutton);
		radiobutton.click();
		return this;
	}

	public SettingsPage clickOnSave() {
		savebutton.click();
		return this;
	}
	
	public boolean isAlertMsgDisplayed() {
		return alertmessage.isDisplayed();
	}
}
