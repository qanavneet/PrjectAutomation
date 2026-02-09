package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[data-qa='name']")
	WebElement nameInput;
	
	@FindBy(css="input[data-qa='email']")
	WebElement emailInput;
	
	@FindBy(css="input[data-qa='subject']")
	WebElement subjectInput;
	
	@FindBy(css="textarea[data-qa='message']")
	WebElement messageInput;
	
	@FindBy(css="input[name='upload_file']")
	WebElement fileUpload;
	
	@FindBy(css="input[data-qa='submit-button']")
	WebElement submitbutton;
	
	@FindBy(css="div.status")
	WebElement submissionMessage;
	
	@FindBy(xpath="//span/i")
	WebElement homeButton;
	
	public void enterName(String name) {
		nameInput.sendKeys(name);
	}
	
	public void enteremail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void enterSubject(String subject) {
		subjectInput.sendKeys(subject);
	}
	
	public void enterMessage(String message) {
		messageInput.sendKeys(message);
	}
	
	public void uploadFile(String path) {
		fileUpload.sendKeys(path);
	}
	
	public void submitForm() {
		submitbutton.click();
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public String getSubmissionText() {
		return submissionMessage.getText();
	}
	
	public void returnHome() {
		homeButton.click();
	}
	
	
	
	
	

}
