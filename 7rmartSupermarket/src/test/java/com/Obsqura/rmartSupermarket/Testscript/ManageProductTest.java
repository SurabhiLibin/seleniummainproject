package com.Obsqura.rmartSupermarket.Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.ManageProduct;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;

public class ManageProductTest extends Base {
	public HomePage homepage;
	public ManageProduct manageproduct;
	@Test
	public void verifyUserIsAbleToSearchProducts() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "Manageproductpage");
		String password = ExcelDataUtility.getStringdata(1, 1, "Manageproductpage");
		loginpage.enterusernameandpassword(username, password);
		
		homepage = loginpage.clickonsignin();
		manageproduct = homepage.clickOnManageProduct();
		String code = ExcelDataUtility.getIntegerdata(10, 2, "Manageproductpage");
		manageproduct.clickOnSearchmenu().enterProductCode(code).clickOnSearch();
		
		String expected = "List Products | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, Constant.ERRORMESSAGEFORMANAGEPRODUCTSPAGE);

	}
}
