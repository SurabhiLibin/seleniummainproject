package com.Obsqura.rmartSupermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.AdminUser;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;

public class AdminUserTest extends Base {
	public HomePage homepage;
	public AdminUser adminuser;

	@Test
	public void verifyusercancreatenewadminuser() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword("admin", "admin");
		homepage = loginpage.clickonsignin();
		adminuser = homepage.clickonAdminUserInfo();
		adminuser.clickOnNew().createnewAdminUser("surabhi1234", "admin371", 3).clickonSave();

		boolean isadminuser = adminuser.isadminuserdisplayed();
		Assert.assertTrue(isadminuser, Constant.ERRORMESSAGEFORADMINPAGE);
	}
}
