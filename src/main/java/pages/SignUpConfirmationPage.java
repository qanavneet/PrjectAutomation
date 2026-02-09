package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpConfirmationPage extends BasePage {

	@FindBy(css = "div[class*='col-sm-9'] h2 b")
	WebElement AccCreationMessage;

	@FindBy(css = "a[data-qa='continue-button']")
	WebElement ContinueButton;

	@FindBy(id = "dismiss-button")
	WebElement closeButton;

	public SignUpConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getMessage() {

		System.out.println("Trying to fetch account text");
		if (isAdPresent()) {
			closeButton.click();
		}
		return AccCreationMessage.getText();
	}

	public void clickContinue() {
		click(ContinueButton);
	}

	public boolean isAdPresent() {
		List<WebElement> ads = driver.findElements(By.id("dismiss-button"));
		if (!ads.isEmpty() && ads.get(0).isDisplayed()) {
			System.out.println("Ad present");
			return true;
		} else {
			System.out.println("Ad not present proceeding");
			return false;
		}

	}

}
