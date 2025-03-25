package com.Obsqura.rmartSupermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;

public class HomePageTest extends Base {
	public HomePage homepage;

	@Test
	public void verifyusercanlogout() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword("admin", "admin");
		homepage = loginpage.clickonsignin();
		homepage.clickonAdmin().clickonlogout();

		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, Constant.ERRORMESSAGEFORLOGOUT);
	}
}
