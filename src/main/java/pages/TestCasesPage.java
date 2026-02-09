package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage extends BasePage {

	public TestCasesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);	}
	
	@FindBy(css="div.col-sm-9 h2 b")
	WebElement Title;

	public String getTitleText() {
		return Title.getText();
	}
}
