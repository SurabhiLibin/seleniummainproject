package com.Obsqura.rmartSupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminbutton;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	WebElement logoutbutton;

	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	WebElement admininfo;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	WebElement category;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement managenews;
	@FindBy(xpath = "//p[text()='Sub Category']")
	WebElement subcategory;
	@FindBy(xpath = "//p[text() = 'Manage Footer Text']")
	WebElement managefootertext;

	public AdminUser clickonAdminUserInfo() {
		admininfo.click();
		return new AdminUser(driver);
	}

	public CategoryPage clickOnCategoryInfo() {
		category.click();
		return new CategoryPage(driver);
	}

	public ManageNewsPage clickonManageNews() {
		managenews.click();
		return new ManageNewsPage(driver);
	}

	public SubCategoryPage clickOnSubCategory() {
		subcategory.click();
		return new SubCategoryPage(driver);
	}
	public ManageFooterTextPage clickOnManageFooterText() {
		managefootertext.click();
		return new ManageFooterTextPage(driver);
	}

	public HomePage clickonAdmin() {
		adminbutton.click();
		return this;
	}

	public HomePage clickonlogout() {
		logoutbutton.click();
		return this;
	}
}
