package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;
import pages.TestCasesPage;

public class VerifyTestCasesPageTest extends BaseTest {

	@Test
	public void verifyTestCases() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hp.isLoaded(), "Home Page is not displayed");
		hp.openTestCases();
		TestCasesPage tc = new TestCasesPage(DriverManager.getDriver());
		Assert.assertEquals(tc.getTitleText(), "Test Cases");
		
	}
}
