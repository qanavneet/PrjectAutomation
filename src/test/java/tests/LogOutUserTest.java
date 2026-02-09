package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.AccountHomePage;
import pages.HomePage;

public class LogOutUserTest extends BaseTest {
	
	@Test
	public void verifySuccessfulLogOut() {
		verifyLoginToAccountVisible();
		HomePage hp = new HomePage(DriverManager.getDriver());
		hp.enterLoginEmail("mmt@gmail.com");
		hp.enterLoginPassword("mmt@gmail.com");	
		hp.clickLoginButton();
		AccountHomePage ap = new AccountHomePage(DriverManager.getDriver());
		Assert.assertEquals(ap.getLoggedInLinkText(), "Logged in as abcd");
		ap.clickLogOut();
		Assert.assertTrue(hp.isSignUpLoginButtonVisible(), "Log in page is not displayed");
		
	}

}
