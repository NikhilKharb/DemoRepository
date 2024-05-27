package endtoend.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import endtoend.Abstract.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	@FindBy(css=".items h3")
	List<WebElement> cartitems;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	
	public Boolean verifyProductsInCart(String itemname) {
		Boolean match = cartitems.stream().anyMatch(item->item.getText().equalsIgnoreCase(itemname));
		return match;
	}
	public CheckoutPage checkOut () {
		checkOut.click();
		CheckoutPage checkOutPage = new CheckoutPage(driver);
		return checkOutPage;
	}

}
