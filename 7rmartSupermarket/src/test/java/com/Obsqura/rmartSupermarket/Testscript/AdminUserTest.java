package com.Obsqura.rmartSupermarket.Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Obsqura.rmartSupermarket.Constant.Constant;
import com.Obsqura.rmartSupermarket.pages.AdminUser;
import com.Obsqura.rmartSupermarket.pages.HomePage;
import com.Obsqura.rmartSupermarket.pages.LoginPage;
import com.Obsqura.rmartSupermarket.utilities.ExcelDataUtility;
import com.Obsqura.rmartSupermarket.utilities.FakerUtility;

public class AdminUserTest extends Base {
	public HomePage homepage;
	public AdminUser adminuser;
	FakerUtility faker=new FakerUtility();


	@Test
	public void verifyusercancreatenewadminuser() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelDataUtility.getStringdata(1, 0, "Adminuserpage");
		String password = ExcelDataUtility.getStringdata(1, 1, "Adminuserpage");
		loginpage.enterusernameandpassword(username, password);
		
		homepage = loginpage.clickonsignin();
		adminuser = homepage.clickonAdminUserInfo();
		//String adminusername = ExcelDataUtility.getStringdata(1, 2,"Adminuserpage" );
		String adminusername = faker.getFakeFirstName();
		String adminpassword = ExcelDataUtility.getStringdata(1, 3,"Adminuserpage"); 
		adminuser.clickOnNew().createnewAdminUser(adminusername,adminpassword, 3).clickonSave();

		boolean isadminuser = adminuser.isadminuserdisplayed();
		Assert.assertTrue(isadminuser, Constant.ERRORMESSAGEFORADMINPAGE);
	}
}
