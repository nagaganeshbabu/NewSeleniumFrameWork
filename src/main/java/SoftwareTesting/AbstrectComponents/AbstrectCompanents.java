package SoftwareTesting.AbstrectComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SoftwareTesting.pageObjects.CartPage;
import SoftwareTesting.pageObjects.OrdersPage;

public class AbstrectCompanents {
	WebDriver driver;

	public AbstrectCompanents(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(css = "button[routerlink=\"/dashboard/myorders\"]")
	WebElement orderHistory;
	
//	public void waitForElementToAppear(By findby) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
//	}
//	
//	
//	public void waitForWebElementToAppear(WebElement cart2) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf((WebElement) cart2));
//	}
//	
//	public void WaitForElementToDissappear(By findBy) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
//	}
	

//	public void WaitForElementToDissappear(By by) throws InterruptedException {
//
//		//Thread.sleep(1);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOf((WebElement) by));
//	}
	public CartPage GotoCart() throws InterruptedException {
		
		//waitForWebElementToAppear(cart);
		Thread.sleep(1000);
		cart.click();
		CartPage Cartpage = new CartPage(driver);
		return Cartpage;

	}
	
	public OrdersPage GotoOrderHistory() throws InterruptedException {
		//waitForWebElementToAppear( orderHistory);
		orderHistory.click();
		OrdersPage OrdersPage = new OrdersPage(driver);
		return OrdersPage;

	}
}
// here i am testing the git 
