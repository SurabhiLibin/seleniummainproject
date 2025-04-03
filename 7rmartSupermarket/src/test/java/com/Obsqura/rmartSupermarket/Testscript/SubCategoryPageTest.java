package com.Obsqura.rmartSupermarket.Testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.SubCategoryPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;
import com.Obsqura.rmartSupermarket.utilities.FakerUtility;

public class SubCategoryPageTest extends Base {
	public HomePage homepage;
	public SubCategoryPage subcategorypage;
	FakerUtility faker = new FakerUtility();
	
	@Test
	public void verifyUserCanAddSubCategory() throws IOException, AWTException  {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "Subcategorypage");
		String password = ExcelDataUtility.getStringdata(1, 1, "Subcategorypage");
		loginpage.enterusernameandpassword(username, password);
		
		homepage = loginpage.clickonsignin();
		subcategorypage = homepage.clickOnSubCategory();
		String category= faker.getFakeCategoryName();
		//String category = ExcelDataUtility.getStringdata(1, 2, "Subcategorypage");
		String subcategory = ExcelDataUtility.getStringdata(1, 3, "Subcategorypage");
		subcategorypage.clickOnNew().addSubCategory(category, subcategory);

		boolean isalreadyexistsalertmsgdisplayed = subcategorypage.isalertdisplayed();
		Assert.assertTrue(isalreadyexistsalertmsgdisplayed, Constant.ALREADYEXISTSALERTMESSAGEFORSUBCATEGORYPAGE);
	}
}
