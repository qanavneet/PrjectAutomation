package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import drivers.DriverManager;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void type(By ele, String text) {
		driver.findElement(ele).clear();
		driver.findElement(ele).sendKeys(text);
	}

	public void type(WebElement ele, String text) {
		ele.clear();
		ele.sendKeys(text);
	}

	public void click(By ele) {
		driver.findElement(ele).click();
	}

	public void click(WebElement ele) {
		ele.click();
	}

	public void selectFromDropDownByText(WebElement ele, String text) {
		Select newselect = new Select(ele);
		newselect.selectByVisibleText(text);
	}

	public boolean isAdPresent() {

		if (DriverManager.getDriver().getCurrentUrl().contains("")) {
			return true;
		} else {
			return false;
		}
	}
}
