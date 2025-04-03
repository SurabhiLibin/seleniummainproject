package com.Obsqura.rmartSupermarket.pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.utilities.FileUploadUtility;
import com.Obsqura.rmartSupermarket.utilities.PageUtility;
import com.Obsqura.rmartSupermarket.utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categoryfield;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageupload;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alreadyexistsalert;

	public SubCategoryPage clickOnNew() {
		newbutton.click();
		return this;
	}

	public SubCategoryPage addSubCategory(String category, String subcategory) {

		Select select = new Select(categoryfield);
		select.selectByVisibleText(category);
		subcategoryfield.sendKeys(subcategory);
		imageupload.sendKeys(Constant.IMAGE);
		pageutility.javaScriptExecutor(driver, save);
		
		waitutility.elementToBeClickable(driver, save);
		save.click();
		return this;
	}

	public boolean isalertdisplayed() {
		return alreadyexistsalert.isDisplayed();
	}

}
