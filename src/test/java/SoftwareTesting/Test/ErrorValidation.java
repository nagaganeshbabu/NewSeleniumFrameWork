package SoftwareTesting.Test;

import java.io.IOException;
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

//import com.sun.net.httpserver.Authenticator.Retry;
import SoftwareTesting.TestComponents.Retry;

import SoftwareTesting.TestComponents.BaseTest;
import SoftwareTesting.pageObjects.CartPage;
import SoftwareTesting.pageObjects.CheckOutPage;
import SoftwareTesting.pageObjects.ConformPage;
import SoftwareTesting.pageObjects.LandingPage;
import SoftwareTesting.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest {
	@Test (groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void submitOrder() throws IOException, InterruptedException {
		//String productNmae = "IPHONE 13 PRO";
		//String Country = "India";
		//String Cvv = "123654";
		LoginPage.LoginApplication("testing1212@gmail.com", "Naga@121");

		Assert.assertEquals("Incorrect email or password.", LoginPage.ErrorMessage());

	}

}
