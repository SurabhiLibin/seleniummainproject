package com.Obsqura.rmartSupermarket.Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.SettingsPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;

public class SettingsPageTest extends Base {
	public HomePage homepage;
	public SettingsPage settingspage;

	@Test
	public void verifyUserIsAbleToCreateNewMenuManagementInfo() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(2, 0, "Settingspage");
		String password = ExcelDataUtility.getStringdata(2, 1, "Settingspage");
		loginpage.enterusernameandpassword(username, password);
		homepage = loginpage.clickonsignin();
		
		settingspage = homepage.clickOnSettings();
		settingspage = homepage.clickOnManageMenu();
		String menu = ExcelDataUtility.getStringdata(2, 2, "Settingspage");
		String parentmenu  =ExcelDataUtility.getStringdata(2, 3, "Settingspage");
		String tablenum = ExcelDataUtility.getIntegerdata(2, 4, "Settingspage");
		String color = ExcelDataUtility.getStringdata(2, 5, "Settingspage");
		settingspage.clickOnNew().enterMenuName(menu).enterParentMenu(parentmenu).enterTableName(tablenum).enterColor(color).clickOnRadiobutton().clickOnSave();
		
		boolean alertmsg = settingspage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg, Constant.EERORMESSAGEFORSETTINGSPAGE);
	}
}
