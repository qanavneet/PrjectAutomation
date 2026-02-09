package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest {
	
	@Test
	public void testContactPage() {
		HomePage hp = new HomePage(DriverManager.getDriver());
	    Assert.assertTrue(hp.isLoaded(), "Home Page is not displayed");
	    hp.openContactUsPage();
	    ContactUsPage cp = new ContactUsPage(DriverManager.getDriver());
	    cp.enterName("Tester");
	    cp.enteremail("a@gmail.com");
	    cp.enterSubject("Test sub");
	    cp.enterMessage("Test message");
	    cp.uploadFile("C:\\Users\\com\\Downloads\\SeleniumAutomationProject.pdf");
	    cp.submitForm();
	    cp.acceptAlert();
	    
	    Assert.assertEquals(cp.getSubmissionText(),"Success! Your details have been submitted successfully." );
	    cp.returnHome();
	    
	}

}
