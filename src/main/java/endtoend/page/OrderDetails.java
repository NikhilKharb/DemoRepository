package endtoend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import endtoend.Abstract.AbstractComponent;

public class OrderDetails extends AbstractComponent {
	WebDriver driver;

	public OrderDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "label[class='ng-star-inserted']")
	WebElement orderNo;

	@FindBy(css = ".hero-primary")

	WebElement message;

	public void getOrderNo() {
		String smessage = message.getText();
		System.out.println(smessage);
		String orderno = orderNo.getText();
		System.out.println("Your Order No. is "+orderno);
		
	}
}