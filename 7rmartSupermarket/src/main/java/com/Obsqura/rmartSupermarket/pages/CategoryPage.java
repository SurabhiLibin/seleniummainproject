package com.Obsqura.rmartSupermarket.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.utilities.FileUploadUtility;
import com.Obsqura.rmartSupermarket.utilities.PageUtility;

public class CategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@placeholder='Enter the Category']")
	WebElement categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement groupdiscount;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement fileupload;
	@FindBy(xpath = "(//input[@name='top_menu'])[2]")
	WebElement topmenu;
	@FindBy(xpath = "(//input[@name='show_home'])[2]")
	WebElement leftmenu;
	@FindBy(xpath = "//button[@name='create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;
	
	public boolean alertsuccess() {
		return successalert.isDisplayed();
	}

	public CategoryPage clickNew() {
		newbutton.click();
		return this;
	}

	public CategoryPage enterCategoryDetails(String category) throws AWTException {
		categoryfield.sendKeys(category);
		groupdiscount.click();
		
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.sendkeysForFileUpload(fileupload, Constant.IMAGE);
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,100000)");
		//pageutility.javaScriptExecutor(driver, topmenu);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		wait.until(ExpectedConditions.elementToBeClickable(topmenu));
		topmenu.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(45));
		wait1.until(ExpectedConditions.elementToBeClickable(leftmenu));
		leftmenu.click();
		return this;
	}

	public CategoryPage clickOnSave() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,50000)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(savebutton));
		savebutton.click();
		return this;
	}
}
