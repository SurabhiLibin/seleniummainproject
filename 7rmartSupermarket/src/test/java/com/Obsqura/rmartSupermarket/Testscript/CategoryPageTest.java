package com.Obsqura.rmartSupermarket.Testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.CategoryPage;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;
import com.Obsqura.rmartSupermarket.utilities.FakerUtility;

public class CategoryPageTest extends Base {

	public LoginPage loginpage;
	public HomePage homepage;
	public CategoryPage categorypage;
	FakerUtility faker = new FakerUtility();

	@Test(retryAnalyzer = com.Obsqura.rmartSupermarket.retry.Retry.class)
	public void verifyUserCanAddaNewCategory() throws AWTException, IOException {

		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "Categorypage");
		String password = ExcelDataUtility.getStringdata(1, 1, "Categorypage");
		loginpage.enterusernameandpassword(username, password);

		homepage = loginpage.clickonsignin();
		categorypage = homepage.clickOnCategoryInfo();
		String category = faker.getFakeCategoryName();
		// String category = ExcelDataUtility.getStringdata(1, 2, "Categorypage");
		categorypage.clickNew().enterCategoryDetails(category).clickOnSave();

		boolean issuccessmessage = categorypage.alertsuccess();
		Assert.assertTrue(issuccessmessage, Constant.ALERTMESSAGEFORCATEGORYPAGE);

	}
}
