package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class ProductDetailsTest extends BaseTest {

	@Test
	public void productDetails() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hp.isLoaded(), "Home Page is not displayed");
		hp.openProductPage();
		ProductsPage pp = new ProductsPage(DriverManager.getDriver());
		Assert.assertEquals(pp.getTitleText(), "ALL PRODUCTS");
		Assert.assertFalse(pp.getProductsList().isEmpty(), "Products list should not be empty");
		pp.openFirstProd();
		ProductDetailsPage pd = new ProductDetailsPage(DriverManager.getDriver());
		List<WebElement> productsName = pp.getProductsList();
		List<WebElement> productsPrice = pp.getProductPrices();
		List<WebElement> productParams = pd.getProductParams();
		Assert.assertEquals(productsName.get(0).getText(), pd.getProdName());
		Assert.assertEquals(productsPrice.get(0).getText(), pd.getProdPrice());
		Assert.assertTrue(productParams.get(0).getText().contains("Category"), "Category is not present");
		
				
	}
}
