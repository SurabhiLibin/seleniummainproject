package com.Obsqura.rmartSupermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.ManageFooterTextPage;

public class ManageFooterTextPageTest extends Base {
	public HomePage homepage;
	public ManageFooterTextPage managefootertextpage;
  @Test
  public void verifyUserCanCreateFooterTextInfo() {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterusernameandpassword("admin", "admin");
	  homepage = loginpage.clickonsignin();
	  managefootertextpage = homepage.clickOnManageFooterText();
	  managefootertextpage.clickOnAction().enterFooterDetails("abc, Kerala", "xyz@gmail.com", "987654").clickOnUpdate();
	  
	  String expected = "Footer Text | 7rmart supermarket";
	  String actual = driver.getTitle();
	  Assert.assertEquals(actual, expected, "page not displayed" );
  }
}
