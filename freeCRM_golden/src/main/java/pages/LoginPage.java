package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;


public class LoginPage extends TestBase{
	
	//Page Objects
	@FindBy(name = "username")
	WebElement name;
	
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public HomePage userLoginMethod(String uname, String pwd) {
		name.sendKeys(uname);
		pass.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean loginPageLogo() {
		return logo.isDisplayed();
	}	
}
