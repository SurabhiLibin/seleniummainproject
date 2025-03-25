package com.Obsqura.rmartSupermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;

public class LoginPageTest extends Base {
	public HomePage homepage;

	@Test(dataProvider = "details")
	public void verifyvalidusernameandpassword(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword(username, password);
		homepage = loginpage.clickonsignin();

		String expected = "Dashboard | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, Constant.ERRORMESSAGEFORLOGIN);
	}

	@Test
	@Parameters({ "username", "password" })
	public void verifyinvalidusernameandvalidpassword(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword(username, password);
		homepage = loginpage.clickonsignin();
	}

	@Test
	public void verifyvalidusernameandinvalidpassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword("admin", "abc");
		homepage = loginpage.clickonsignin();

		boolean isalert = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalert, Constant.ALERTMESSAGEFORLOGIN);
	}

	@Test
	public void verifyinvalidusernameandpassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword("suru", "string");
		homepage = loginpage.clickonsignin();
	}

	@DataProvider(name = "details")
	public Object[][] testValues() {
		Object values[][] = { { "123", "abs" }, { "obsqura", "flower" }, { "admin", "admin" } };
		return values;
	}

}
