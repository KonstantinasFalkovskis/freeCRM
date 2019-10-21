package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage; //LoginPage.class object is defining on class level
	HomePage homePage;
	
	//Constructor of PageObject
	public LoginPageTest() {
		super(); //<- calling superclass - TestBase constructor. In our case it is properties
	}
	
	//have to create LoginPage.class Object
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.loginPageTitle();
		Assert.assertEquals(title, prop.getProperty("LoginPageTitle"));
	}
	
	@Test(priority=2)
	public void crmLogo() {
		boolean flag = loginPage.loginPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.userLoginMethod(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
