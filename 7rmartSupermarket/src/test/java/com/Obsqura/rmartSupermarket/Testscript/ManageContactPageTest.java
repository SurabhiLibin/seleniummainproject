package com.Obsqura.rmartSupermarket.Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.pages.ManageContactPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;

public class ManageContactPageTest extends Base {
	public HomePage homepage;
	public ManageContactPage managecontactpage;
	@Test
	public void verifyUserCanUpdateContactUsInfo() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "ManageContactPage");
		String password = ExcelDataUtility.getStringdata(1, 1, "ManageContactPage");
		loginpage.enterusernameandpassword(username, password);
		homepage = loginpage.clickonsignin();
		managecontactpage = homepage.clickOnManageContact();
		managecontactpage.clickOnAction();
		String phoneno = ExcelDataUtility.getIntegerdata(1, 2, "ManageContactPage");
		String email = ExcelDataUtility.getStringdata(1, 3, "ManageContactPage");
		String address = ExcelDataUtility.getStringdata(1, 4, "ManageContactPage");
		String time = ExcelDataUtility.getIntegerdata(1, 5, "ManageContactPage");
		String charge = ExcelDataUtility.getIntegerdata(1, 6, "ManageContactPage");
		managecontactpage.enterPhonenum(phoneno).enterEmail(email).enterAddress(address).enterDelTime(time).enterDelCharge(charge).clickOnUpdate();
		
		boolean isalertmsg = managecontactpage.isAlertDisplayed();
		Assert.assertTrue(isalertmsg, Constant.ERRORMESSAGEFORMANAGECONTACTSPAGE);
	}
	
	
}
