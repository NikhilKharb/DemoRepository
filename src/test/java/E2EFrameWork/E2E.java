package E2EFrameWork;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import endtoend.TestComponents.BaseTest;
import endtoend.page.CartPage;
import endtoend.page.CheckoutPage;
import endtoend.page.OrderDetails;
import endtoend.page.OrderPage;
import endtoend.page.ProductCatalog;

public class E2E extends BaseTest {
	// String item = "ADIDAS ORIGINAL";
	@Test(dataProvider = "getData", groups = "purchaseOrder")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		String countryinitials = "ind";
		String cvv = "123";
		String NameOnCard = "Nikhil";
		ProductCatalog productCatalog = landingPage.loginaction(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalog.getItemList();

		CartPage cartpage = productCatalog.addToCart(input.get("item"));
		productCatalog.goToCart();

		Boolean match = cartpage.verifyProductsInCart(input.get("item"));

		Assert.assertTrue(match);
		CheckoutPage checkOutPage = cartpage.checkOut();
		OrderDetails orderDetails = checkOutPage.placeOrder(NameOnCard, cvv, countryinitials);

		orderDetails.getOrderNo();
		System.out.println(orderDetails);
		System.out.println(products);

	}

	@Test(dependsOnMethods = { "submitOrder" }, dataProvider = "getData", groups = "purchaseOrder")
	public void checkOrderHistory(HashMap<String, String> input) {
		ProductCatalog productCatalog = landingPage.loginaction(input.get("email"), input.get("password"));
		OrderPage ordersPage = productCatalog.ordersPage();
		Assert.assertTrue(ordersPage.verifyOrders(input.get("item")));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(
				"C:\\Users\\nikhil.kharb\\eclipse-workspace\\E2EFrameWork\\src\\test\\java\\dataFile\\PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
