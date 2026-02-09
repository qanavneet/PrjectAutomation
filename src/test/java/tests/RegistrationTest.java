package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.AccountHomePage;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignUpConfirmationPage;

public class RegistrationTest extends BaseTest {

	@Test
	public void userCanRegisterSuccessfully() {
		
		HomePage hp = new HomePage(DriverManager.getDriver());
		verifyNewSignUpVisible();
		hp.enterName("APP");
		hp.enterEmail("qwertyuuuudduaaaauz@gmail.com");
		hp.clickSignUp();
		Assert.assertEquals(hp.getEnterInfoText(), "ENTER ACCOUNT INFORMATION");
		RegistrationPage rp = new RegistrationPage(DriverManager.getDriver());
		rp.selectMaleTitle();
		rp.enterName("APP");
		rp.enterPassword("Indian@1111111");
		rp.selectDay("26");
		rp.selectMonth("January");
		rp.selectYear("2001");
		rp.selectNewsletterCheckbox();
		rp.selectOffersCheckbox();
		rp.enterFirstName("APP");
		rp.enterLastName("DRI");
		rp.enterCompanyName("CodeDarshi");
		rp.enterAddress("NYK");
		rp.enterAddress2("CMK");
		rp.selectCountry("India");
		rp.enterState("Maharashtra");
		rp.enterCity("khed");
		rp.enterZip("213567");
		rp.enterMobileNum("888888888");
		rp.createAccButtonClick();
		
		SignUpConfirmationPage sp = new SignUpConfirmationPage(DriverManager.getDriver());
		Assert.assertEquals(sp.getMessage(), "ACCOUNT CREATED!");
		sp.clickContinue();
		AccountHomePage ap = new AccountHomePage(DriverManager.getDriver());
		Assert.assertEquals(ap.getLoggedInLinkText(), "Logged in as APP");	
		
		ap.deleteAccount();
		Assert.assertEquals(ap.getDeletionText(), "ACCOUNT DELETED!");
	}
	
	@Test
	public void existingUserTest() {
		verifyNewSignUpVisible();
		HomePage hp = new HomePage(DriverManager.getDriver());
		hp.enterName("abcd");
		hp.enterEmail("mmt@gmail.com");
		hp.clickSignUp();
		Assert.assertEquals(hp.getExistingUserErrorTest(), "Email Address already exist!");
		
	}


}
