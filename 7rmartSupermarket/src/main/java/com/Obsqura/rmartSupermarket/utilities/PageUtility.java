package com.Obsqura.rmartSupermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectByvalue(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectByIndex(WebElement element, int num) {
		Select select = new Select(element);
		select.selectByIndex(num);
	}
	public void javaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,400)");
	}
	public void roboClass(WebDriver driver, WebElement element) throws AWTException {
		StringSelection selection = new StringSelection("\"C:\\Users\\Dell\\Desktop\\apple.jpg\"");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robo = new Robot();
		robo.delay(2500);

		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

}
