package endtoend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import endtoend.Abstract.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// WebElement username = driver.findElement(By.id("userEmail"));
	// Page Factory

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public String getErrorMessage() {
		waitWebElementToAppear(errorMessage);
		return errorMessage.getText();
		 
	}
	public ProductCatalog loginaction(String username, String password) {
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
