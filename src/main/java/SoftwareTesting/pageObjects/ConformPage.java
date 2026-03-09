package SoftwareTesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SoftwareTesting.AbstrectComponents.AbstrectCompanents;

public class ConformPage  extends AbstrectCompanents{
	
	WebDriver driver;
	
	public ConformPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
@FindBy(css =".hero-primary")
WebElement confomMsg;


	//String confomMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();

	//Assert.assertTrue(confomMsg.equalsIgnoreCase("Thankyou for the order."));

public String ConformationText() {
	
	
	
	return confomMsg.getText();
	
}

}
