package com.Obsqura.rmartSupermarket.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Obsqura.rmartSupermarket.utilities.PageUtility;

public class AdminUser {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement newusername;
	@FindBy(xpath = "//input[@name='password']")
	WebElement newpassword;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement usertypefield;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;

	@FindBy(xpath = "//h1[text()='Admin Users']")
	WebElement adminuser;

	public AdminUser clickOnNew() {
		newbutton.click();
		return this;
	}

	public AdminUser createnewAdminUser(String username, String password, int usertype) {

		newusername.sendKeys(username);
		newpassword.sendKeys(password);
        // pageutility.selectByVisibleText(usertypefield, usertype);
		// pageutility.selectByvalue(usertypefield, usertype);
		pageutility.selectByIndex(usertypefield, usertype);
		return this;
	}

	public AdminUser clickonSave() {
		savebutton.click();
		return this;
	}

	public boolean isadminuserdisplayed() {
		return adminuser.isDisplayed();
	}

}
