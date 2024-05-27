package endtoend.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import endtoend.Abstract.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	@FindBy(css=".items h3")
	List<WebElement> cartitems;
	
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> itemOrder;
	
	
	public Boolean verifyOrders(String itemname) {
		Boolean match = itemOrder.stream().anyMatch(item->item.getText().equalsIgnoreCase(itemname));
		
		return match;
	}
	

}
