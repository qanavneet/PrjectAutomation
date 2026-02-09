package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountHomePage extends BasePage {

	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li/a[contains(text(), 'Logged in as')]")
	WebElement loggedInAsLink;
	
	@FindBy(xpath="//a[text()=' Delete Account']")
	WebElement deleteAccount;
	
	@FindBy(css="h2 b")
	WebElement accountDeleted;
	
	@FindBy(css="a[href='/logout']")
	WebElement LogOutButton;


	public String getLoggedInLinkText() {
		try {
			loggedInAsLink.isDisplayed();
		}
		catch(Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(loggedInAsLink));
		}
		return loggedInAsLink.getText();
	}
	
	public void deleteAccount() {
		deleteAccount.click();
	}
	
	public String getDeletionText() {
		return accountDeleted.getText();
	}
	
	public void clickLogOut() {
		LogOutButton.click();
	}


}
