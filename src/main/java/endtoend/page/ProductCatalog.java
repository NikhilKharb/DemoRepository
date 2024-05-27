package endtoend.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import endtoend.Abstract.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".col-lg-4")
	List<WebElement> items;
	@FindBy(css = ".ng-animating")
	WebElement loader;

	By itemslist = By.cssSelector(".col-lg-4");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.id("toast-container");

	public List<WebElement> getItemList() {

		waitElementToAppear(itemslist);
		return items;

	}

	public WebElement getItemByName(String itemName) {
		WebElement itemToCart = getItemList().stream()
				.filter(item -> item.findElement(By.cssSelector("b")).getText().equals(itemName)).findFirst()
				.orElse(null);
		return itemToCart;
	}

	public CartPage addToCart(String itemName) throws InterruptedException {
		WebElement item = getItemByName(itemName);
		item.findElement(addToCart).click();
		//waitElementToDisappear(loader);
		Thread.sleep(1000);
		waitElementToAppear(toastMessage);
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}

}
