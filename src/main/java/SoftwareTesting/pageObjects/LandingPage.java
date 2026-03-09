package SoftwareTesting.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTesting.AbstrectComponents.AbstrectCompanents;

public class LandingPage extends AbstrectCompanents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement UserMail;

	@FindBy(id = "userPassword")
	WebElement paswordEle;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = "div[class*='ng-trigger-flyInOut ']")
	WebElement errorMessage;
	
	public ProductCatalogue LoginApplication(String Email, String Password) {

		UserMail.sendKeys(Email);

		paswordEle.sendKeys(Password);

		submit.click();
		ProductCatalogue  ProductCatalogues = new ProductCatalogue(driver);
		
		return  ProductCatalogues;
	}
	
	public String ErrorMessage() {
		//waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/#/dashboard/dash");
	}

}
