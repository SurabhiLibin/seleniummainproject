package com.Obsqura.rmartSupermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.ManageNewsPage;

public class ManageNewsPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageNewsPage managenewspage;

	@Test
	public void verifyUserCanCreateNewMessages() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusernameandpassword("admin", "admin");
		homepage = loginpage.clickonsignin();
		managenewspage = homepage.clickonManageNews();
		managenewspage.enterNewMessage("50% discount");

		boolean alertmsg = managenewspage.isalertdisplayed();
		Assert.assertTrue(alertmsg, "alert msg not displayed");
	}
}
