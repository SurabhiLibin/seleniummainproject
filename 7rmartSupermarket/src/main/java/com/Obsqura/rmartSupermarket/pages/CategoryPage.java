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

	public CategoryPage clickNew() {
		newbutton.click();
		return this;
	}

	public CategoryPage enterCategoryDetails(String category) throws AWTException {
		categoryfield.sendKeys(category);
		groupdiscount.click();
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("window.scrollBy(0,6000)");
		pageutility.javaScriptExecutor(driver, fileupload);
		fileupload.sendKeys("C:\\\\Users\\\\Dell\\\\Desktop\\\\apple.jpg");
		
		
		/*StringSelection selection = new StringSelection("\"C:\\Users\\Dell\\Desktop\\apple.jpg\"");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robo = new Robot();
		robo.delay(2500);

		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);*/
		//pageutility.roboClass(driver, fileupload);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(topmenu));
		//wait.until(ExpectedConditions.elementToBeSelected(topmenu));
		//wait.until(ExpectedConditions.elementSelectionStateToBe(topmenu, false));
		//wait.until(ExpectedConditions.titleContains(categoryfield));
		//wait.until(ExpectedConditions.invisibilityOf(fileupload));
	
		topmenu.click();
		leftmenu.click();
		return this;
	}

	public CategoryPage clickOnSave() {
		savebutton.click();
		return this;
	}
}
