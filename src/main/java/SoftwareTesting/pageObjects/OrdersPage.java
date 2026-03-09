package SoftwareTesting.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTesting.AbstrectComponents.AbstrectCompanents;

public class OrdersPage extends AbstrectCompanents {
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy (css="tr td:nth-child(3)")
	List<WebElement> Orderitems;

	
	public boolean checkItemsOrderHistory(String ProdectName) {
		boolean check = Orderitems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(ProdectName));
		return check;
	}

	
}
