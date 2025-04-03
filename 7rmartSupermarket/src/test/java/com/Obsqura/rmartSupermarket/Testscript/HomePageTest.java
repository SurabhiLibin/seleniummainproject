package com.Obsqura.rmartSupermarket.Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;

public class HomePageTest extends Base {
	public HomePage homepage;

	@Test
	public void verifyusercanlogout() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "Homepage");
		String password = ExcelDataUtility.getStringdata(1, 1, "Homepage");
		loginpage.enterusernameandpassword(username, password);
		homepage = loginpage.clickonsignin();
		homepage.clickonAdmin().clickonlogout();

		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, Constant.ERRORMESSAGEFORLOGOUT);
	}
}
