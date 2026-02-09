package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.product-information h2")
	WebElement prodName;
	
	@FindBy(css="div.product-information span span")
	WebElement prodPrice;
	
	@FindBy(css="div.product-information p")
	WebElement productParams;
	
	public String getProdName() {
		return prodName.getText();
	}
	
	public String getProdPrice() {
		return prodPrice.getText();
	}
	
	public List<WebElement> getProductParams(){
		return driver.findElements(By.cssSelector("div.product-information p"));
	}

}
