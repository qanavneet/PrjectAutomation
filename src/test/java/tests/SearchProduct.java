package tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;
import pages.ProductsPage;

public class SearchProduct extends BaseTest  {
	
	@Test
	public void searchProductTest() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hp.isLoaded(), "Home Page is not displayed");
		hp.openProductPage();
		ProductsPage pp = new ProductsPage(DriverManager.getDriver());
		Assert.assertEquals(pp.getTitleText(), "ALL PRODUCTS");
		pp.searchproduct("Tshirt");
		List<WebElement> searchProductsList = pp.getProductsList();
		Iterator<WebElement> it = searchProductsList.iterator();
		while(it.hasNext()) {
			WebElement pro = it.next();
			String text = pro.getText().toLowerCase()
                    .replace("-", "")
                    .replace(" ", "");
			
			Assert.assertTrue(text.contains("tshirt"), "Expected 'Tshirt' but found: " + text);
		}
		
	}
}
