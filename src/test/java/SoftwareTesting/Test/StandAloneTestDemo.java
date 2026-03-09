package SoftwareTesting.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestDemo {

	@Test
	 public void startingpractiove(){
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/client/#/dashboard/dash");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("userEmail")).sendKeys("testing1212@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Naga@1212");

		driver.findElement(By.id("login")).click();

		String item = "ZARA COAT 3";

		// String n = "ADIDAs";

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement name = products.stream()
				.filter(product -> product.findElement(By.cssSelector(".mb-3 b")).getText().equals(item)).findFirst()
				.orElse(null);

		name.findElement(By.cssSelector(".mb-3 button:last-of-type")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		// Thread.sleep(1000);

		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

		List<WebElement> cartitems = driver.findElements(By.cssSelector(".cart div h3"));

		boolean check = cartitems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(item));

		Assert.assertTrue(check);

		driver.findElement(By.cssSelector(".totalRow button")).click();
		//Thread.sleep(1000);
		// driver.findElement(By.cssSelector("input[class*='ng-touched']")).sendKeys("sddvwaegmail.com");

		driver.findElement(By.xpath("(//div/input[@class='input txt'])[1]")).sendKeys("456321");

		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("section[class$='ta-results list-group ng-star-inserted']")));

		driver.findElement(By.cssSelector("button[type = 'button']:last-child")).click();
		// List<WebElement> n = driver.findElements(By.cssSelector("button span"));

		driver.findElement(By.cssSelector("a[class = 'btnn action__submit ng-star-inserted']")).click();

		String confomMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(confomMsg.equalsIgnoreCase("Thankyou for the order."));

		System.out
				.println(driver.findElement(By.cssSelector("label[class ='ng-star-inserted']:first-child")).getText());

	}

}
