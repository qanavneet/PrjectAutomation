package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h2.title")
	WebElement title;

	@FindBy(css = "div.productinfo p")
	WebElement productsTiles;

	@FindBy(css = "a[href='/product_details/1']")
	WebElement firstProdDetails;

	@FindBy(css = "div.productinfo  h2")
	WebElement prices;

	@FindBy(css = "input[name='search']")
	WebElement searchBox;

	@FindBy(css = "button#submit_search")
	WebElement searchButton;

	public String getTitleText() {
		if (isAdPresent()) {

			driver.navigate().refresh();

		}
		List<WebElement> titles = driver.findElements(By.cssSelector("h2.title"));
		System.out.println(titles.size());
		return titles.get(0).getText();
	}

	public List<WebElement> getProductsList() {
		return driver.findElements(By.cssSelector("div.productinfo p"));
	}

	public List<WebElement> getProductPrices() {
		return driver.findElements(By.cssSelector("prices"));
	}

	public void openFirstProd() {
		firstProdDetails.click();
	}

	public void searchproduct(String productname) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println((driver.findElements(By.cssSelector("input[name='search']"))).size());
		js.executeScript("arguments[0].scrollIntoView(true);", searchBox);
		
		searchBox.sendKeys(productname);
		searchButton.click();
	}

}
