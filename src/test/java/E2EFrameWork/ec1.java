package E2EFrameWork;

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

import endtoend.page.LandingPage;

public class ec1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.id("userEmail")).sendKeys("nikhil.kharb@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Nikhil@7313");
		driver.findElement(By.id("login")).click();
		String toast1 = driver.findElement(By.id("toast-container")).getText();
		System.out.println(toast1);
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> items = driver.findElements(By.cssSelector(".col-lg-4"));

		WebElement item1 = items.stream()
				.filter(item -> item.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst()
				.orElse(null);
		WebElement item2 = items.stream()
				.filter(item -> item.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst()
				.orElse(null);
		item1.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		String toast2 = driver.findElement(By.id("toast-container")).getText();
		System.out.println(toast2);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("toast-container"))));
		item2.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		String toast3 = driver.findElement(By.id("toast-container")).getText();
		System.out.println(toast3);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("toast-container"))));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartitems = driver.findElements(By.cssSelector(".items"));

		boolean match1 = cartitems.stream().anyMatch(
				cartitem -> cartitem.findElement(By.cssSelector(".items h3")).getText().equals("ADIDAS ORIGINAL"));
		Assert.assertTrue(match1);
		boolean match2 = cartitems.stream().anyMatch(
				cartitem -> cartitem.findElement(By.cssSelector(".items h3")).getText().equals("IPHONE 13 PRO"));
		Assert.assertTrue(match2);

		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		// .ta-item:nth-of-type(2)
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".actions a")).click();

		String order1 = driver.findElement(By.cssSelector("label[class='ng-star-inserted']"))
				.getText();

		String order2 = driver.findElement(By.cssSelector(".em-spacer-1 label.ng-star-inserted:nth-of-type(2)"))
				.getText();
		System.out.println("Order No.1 is " + order1);
		System.out.println("Order No.2 is " + order2);

		driver.quit();

	}

}
