package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;

public class SubscriptionTest extends BaseTest {
	
	@Test
	public void SubscriptionExistTest() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hp.isLoaded(), "Home Page is not displayed");
		hp.scrollToFooter();
		Assert.assertEquals(hp.getSubscriptionText(), "SUBSCRIPTION");
		hp.enterSubEmail("a@mail.com");
		hp.clicksubscribeButton();
		Assert.assertEquals(hp.getsubscriptionSuccessAlertText(), "You have been successfully subscribed!");
	}

}
