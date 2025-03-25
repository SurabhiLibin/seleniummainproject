package com.Obsqura.rmartSupermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.SubCategoryPage;

public class SubCategoryPageTest extends Base {
	public HomePage homepage;
	public SubCategoryPage subcategorypage;

	@Test
	public void verifyUserCanAddSubCategory() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword("admin", "admin");
		homepage = loginpage.clickonsignin();
		subcategorypage = homepage.clickOnSubCategory();
		subcategorypage.clickOnNew().addSubCategory("Fresh_fruits", "apple");

		boolean isalreadyexistsalertmsgdisplayed = subcategorypage.isalertdisplayed();
		Assert.assertTrue(isalreadyexistsalertmsgdisplayed, Constant.ALREADYEXISTSALERTMESSAGEFORSUBCATEGORYPAGE);
	}
}
