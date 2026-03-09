package SoftwareTesting.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTesting.AbstrectComponents.AbstrectCompanents;

public class CartPage extends AbstrectCompanents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy (css=".cart div h3")
	List<WebElement> cartitems;
	
	@FindBy(css =".totalRow button")
	WebElement button;
	public boolean checkItemsInCart(String ProdectName) {
		boolean check = cartitems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(ProdectName));
		return check;
	}
	
	public CheckOutPage CheckOut() {
		
		button.click();
		return new CheckOutPage(driver);	
	}
	
}
