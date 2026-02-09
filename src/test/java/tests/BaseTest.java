package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import drivers.DriverFactory;
import drivers.DriverManager;
import pages.HomePage;
import utilities.ConfigReader;

public class BaseTest {

	@Parameters("browserName")
	@BeforeSuite
	public void setUp(String browser) {
		WebDriver driver = DriverFactory.createDriver(browser);
		DriverManager.setDriver(driver);
		driver.get(ConfigReader.get("base.url"));
	}

	@AfterSuite
	public void tearDown() {

		if (DriverManager.getDriver() != null) {
			WebDriver driver = DriverManager.getDriver();
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
	
	public void verifyNewSignUpVisible() {
		HomePage hp = new HomePage(DriverManager.getDriver());
	    Assert.assertTrue(hp.isLoaded(), "Home Page is not displayed");
	    Assert.assertTrue(hp.isSignUpLoginButtonVisible(), "Signup/Login button is not visible");
        Reporter.log("✔ Signup/Login button is visible", true);
	    hp.clickSignUpLogin();
		Assert.assertTrue(hp.isNewUserSignupTextVisible(), "New User Signup Text is not visible");
	}
	
	public void verifyLoginToAccountVisible() {
		HomePage hp = new HomePage(DriverManager.getDriver());
	    Assert.assertTrue(hp.isLoaded(), "Home Page is not displayed");
	    Assert.assertTrue(hp.isSignUpLoginButtonVisible(), "Signup/Login button is not visible");
        Reporter.log("✔ Signup/Login button is visible", true);
	    hp.clickSignUpLogin();
	    Assert.assertTrue(hp.isLoginToAccountTextVisible(), "Login to your account Text is not visible");
	}
	
	public boolean isAdPresent() {
		
		if(DriverManager.getDriver().getCurrentUrl().contains("")) {
			return true;
		}
		else {
			return false;
		}
	}

}
