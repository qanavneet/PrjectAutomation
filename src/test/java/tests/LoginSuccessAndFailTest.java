package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.AccountHomePage;
import pages.HomePage;

public class LoginSuccessAndFailTest extends BaseTest {

	@Test
	public void VerifySuccessfulLogin() {
		verifyLoginToAccountVisible();
		HomePage hp = new HomePage(DriverManager.getDriver());
		hp.enterLoginEmail("Automation123@gmail.com");
		hp.enterLoginPassword("Indian@123456");	
		hp.clickLoginButton();
		AccountHomePage ap = new AccountHomePage(DriverManager.getDriver());
		Assert.assertEquals(ap.getLoggedInLinkText(), "Logged in as automation");
		ap.deleteAccount();
		Assert.assertEquals(ap.getDeletionText(), "ACCOUNT DELETED!");
}
	
	@Test
	public void LoginFailureTest() {
		verifyLoginToAccountVisible();
		HomePage hp = new HomePage(DriverManager.getDriver());
		hp.enterLoginEmail("Automation123@gmail.com");
		hp.enterLoginPassword("Indian@123456");
		hp.clickLoginButton();
		Assert.assertEquals(hp.getLoginErrorText().trim(), "Your email or password is incorrect!");
	}
}