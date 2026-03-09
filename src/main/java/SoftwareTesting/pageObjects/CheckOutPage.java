package SoftwareTesting.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SoftwareTesting.AbstrectComponents.AbstrectCompanents;

public class CheckOutPage extends AbstrectCompanents {
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "(//div/input[@class='input txt'])[1]")
	WebElement cvv;
	
	@FindBy (css ="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css = "button[type = 'button']:nth-of-type(1)")
	WebElement selectCountry;
	
	@FindBy(css = "a[class = 'btnn action__submit ng-star-inserted']")
	WebElement PlaceOrder;
	
	By result  =By.cssSelector(".ta-results");
	
	//driver.findElement(By.cssSelector("a[class = 'btnn action__submit ng-star-inserted']")).click();
	
	//driver.findElement(By.cssSelector("button[type = 'button']:last-child")).click();
	
	//driver.findElement(By.xpath("(//div/input[@class='input txt'])[1]")).sendKeys("456321");

	//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
	
	
	public void inputValues(String values, String pin) {
		
		
		Actions a = new Actions(driver); 
		cvv.sendKeys(pin);
		a.sendKeys(country , values).build().perform();;
		//waitForWebElementToAppear(result);
		
		//waitForWebElementToAppear(driver.findElement(result));
		
		selectCountry.click();
	}
	
//	public ConformPage PalceOrder() throws InterruptedException {
//		//Thread.sleep(1000);
//		PlaceOrder.click();
//		
//		
//		return new ConformPage(driver);
//		
//		
//	}
	
//	public ConformPage PalceOrder() {
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    WebElement placeOrder =
//	        wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector("a[class='btnn action__submit ng-star-inserted']")
//	        ));
//
//	    placeOrder.click();
//	    return new ConformPage(driver);
//	}
//	
	

	
	public ConformPage PalceOrder() throws InterruptedException {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	  //  waitForWebElementToAppear(PlaceOrder);
	  //  WaitForElementToDissappear(By.cssSelector(".ngx-spinner-overlay"));

	    wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder));

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", PlaceOrder);
	    js.executeScript("arguments[0].click();", PlaceOrder);

	    return new ConformPage(driver);
	}


	
	
	

}
