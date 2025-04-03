package com.Obsqura.rmartSupermarket.Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;

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
	public void verifyvalidusernameandinvalidpassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "Loginpage");
		String password = ExcelDataUtility.getStringdata(1, 1, "Loginpage");
		loginpage.enterusernameandpassword(username, password);
		homepage = loginpage.clickonsignin();

		boolean isalert = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalert, Constant.ALERTMESSAGEFORLOGIN);
	}

	@Test
	public void verifyinvalidusernameandpassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(2, 0, "Loginpage");
		String password = ExcelDataUtility.getStringdata(2, 1,"Loginpage");
		loginpage.enterusernameandpassword(username, password);
		homepage = loginpage.clickonsignin();
	}

	@DataProvider(name = "details")
	public Object[][] testValues() {
		Object values[][] = { { "123", "abs" }, { "obsqura", "flower" }, { "admin", "admin" } };
		return values;
	}

}
