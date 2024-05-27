package E2EFrameWork;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import endtoend.TestComponents.BaseTest;
import endtoend.TestComponents.RetryListeners;
import endtoend.page.CartPage;
import endtoend.page.CheckoutPage;
import endtoend.page.LandingPage;
import endtoend.page.OrderDetails;
import endtoend.page.ProductCatalog;

public class ErrorValidations extends BaseTest {

	@Test(groups = {"ErrorHandling"},retryAnalyzer=RetryListeners.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		landingPage.loginaction("nikhil.kharb@gmail.com", "Nikhil@12347313");
		
		Assert.assertEquals( landingPage.getErrorMessage(),"Incorrect email or password.");
		System.out.println(landingPage.getErrorMessage());

	}
	@Test
	public void CheckItemsInCatalog() {
		
	}

}
