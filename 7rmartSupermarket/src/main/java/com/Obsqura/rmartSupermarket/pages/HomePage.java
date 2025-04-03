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
	@FindBy(xpath = "(//a[@class='small-box-footer'])[4]")
	WebElement subcategory;
	@FindBy(xpath = "//p[text() = 'Manage Footer Text']")
	WebElement managefootertext;
	@FindBy(xpath = "//p[text()='Manage Contact']")
	WebElement managecontact;
	@FindBy(xpath = "(//a[@class=' nav-link'])[3]")
	WebElement settingsmenu;
	@FindBy(xpath = "(//a[@class=' nav-link'])[4]")
	WebElement managemenu;
	@FindBy(xpath = "//p[text()='Manage Product']")
	WebElement manageproductmenu;

	public ManageProduct clickOnManageProduct() {
		manageproductmenu.click();
		return new ManageProduct(driver);
	}

	public SettingsPage clickOnSettings() {
		settingsmenu.click();
		return new SettingsPage(driver);
	}

	public SettingsPage clickOnManageMenu() {
		managemenu.click();
		return new SettingsPage(driver);
	}

	public ManageContactPage clickOnManageContact() {
		managecontact.click();
		return new ManageContactPage(driver);
	}

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
