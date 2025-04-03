package com.Obsqura.rmartSupermarket.Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.ManageNewsPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;

public class ManageNewsPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageNewsPage managenewspage;

	@Test
	public void verifyUserCanCreateNewMessages() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "Managenewspage");
		String password = ExcelDataUtility.getStringdata(1, 1, "Managenewspage");
		loginpage.enterusernameandpassword(username, password);
		
		homepage = loginpage.clickonsignin();
		managenewspage = homepage.clickonManageNews();
		String news = ExcelDataUtility.getStringdata(1, 2, "Managenewspage");
		managenewspage.enterNewMessage(news);

		boolean alertmsg = managenewspage.isalertdisplayed();
		Assert.assertTrue(alertmsg, Constant.ALERTMESSAGEFORLOGIN);
	}
}
