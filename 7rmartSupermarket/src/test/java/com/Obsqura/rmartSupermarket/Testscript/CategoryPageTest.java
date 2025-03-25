package com.Obsqura.rmartSupermarket.Testscript;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.pages.CategoryPage;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;

public class CategoryPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public CategoryPage categorypage;

	@Test
	public void verifyUserCanAddaNewCategory() throws AWTException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword("admin", "admin");
		homepage = loginpage.clickonsignin();
		categorypage = homepage.clickOnCategoryInfo();
		categorypage.clickNew().enterCategoryDetails("Fruits1").clickOnSave();

	}
}
