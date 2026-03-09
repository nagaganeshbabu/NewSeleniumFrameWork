package SoftwareTesting.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SoftwareTesting.AbstrectComponents.AbstrectCompanents;

public class ProductCatalogue extends AbstrectCompanents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement Spinner;

	By productBy = By.cssSelector(".mb-3");
	By AddToCart = By.cssSelector(".mb-3 button:last-of-type");
	By WaitTextApper = By.cssSelector("#toast-container");
	//By cart = By.cssSelector("button[routerlink='/dashboard/cart']");

	public List<WebElement> getProductList() {
		//waitForElementToAppear(productBy);
		//waitForElementToAppear(productBy);
		return products;
	}

	public WebElement getProductName(String ProductName) { // here we are filter the name and geting the name
		WebElement name = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector(".mb-3 b")).getText().equals(ProductName))
				.findFirst().orElse(null);
		return name;
	}

	public void addProductToCart(String ProductName) throws InterruptedException { // taking that name from getProductName and passing paramenter

		WebElement name = getProductName(ProductName); // from getProductName() we will get actual value and that value
          Thread.sleep(1000);
		                                     //waitForElementToAppear(WaitTextApper);
		                                        //WaitForElementToDissappear(Spinner);
		name.findElement(AddToCart).click(); // and with that we are clicking

	}

}
