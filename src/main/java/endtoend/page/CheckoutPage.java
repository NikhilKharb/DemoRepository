package endtoend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import endtoend.Abstract.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".form-group input")
	WebElement country;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;

	@FindBy(css = ".btnn")
	WebElement checkOut;

	@FindBy(xpath = "//div[@class='form__cc']//div[1]//div[1]//input[1]")
	WebElement cvv;

	@FindBy(xpath = "//div[@class='payment__info']//div[3]//div[1]//input[1]")
	WebElement Name;

	public OrderDetails placeOrder(String NameonCard, String cvvcode, String initials) throws InterruptedException {
		
		Name.sendKeys(NameonCard);
		cvv.sendKeys(cvvcode);
		country.sendKeys(initials);
		selectCountry.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		Thread.sleep(2000);
		checkOut.click();
		OrderDetails orderDetails = new OrderDetails(driver);
		return orderDetails;

	}
}
