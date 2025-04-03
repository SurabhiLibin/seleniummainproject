package com.Obsqura.rmartSupermarket.Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.ManageFooterTextPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;

public class ManageFooterTextPageTest extends Base {
	public HomePage homepage;
	public ManageFooterTextPage managefootertextpage;

	@Test
	public void verifyUserCanCreateFooterTextInfo() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "ManageFooterTextpage");
		String password = ExcelDataUtility.getStringdata(1, 1, "ManageFooterTextpage");
		loginpage.enterusernameandpassword(username, password);
		homepage = loginpage.clickonsignin();
		managefootertextpage = homepage.clickOnManageFooterText();
		String address = ExcelDataUtility.getStringdata(1, 2, "ManageFooterTextpage");
		String email = ExcelDataUtility.getStringdata(1, 3, "ManageFooterTextpage");
		String phone = ExcelDataUtility.getIntegerdata(1, 4, "ManageFooterTextpage");
		//footertextpage.editfooterdata(address, email," 897898654").clickOnUbdate();
		managefootertextpage.clickOnAction().enterFooterDetails(address, email, phone).clickOnUpdate();

		String expected = "Footer Text | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "page not displayed");
	}
}
