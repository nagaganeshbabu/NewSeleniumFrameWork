package SoftwareTesting.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import SoftwareTesting.TestComponents.BaseTest;
import SoftwareTesting.pageObjects.CartPage;
import SoftwareTesting.pageObjects.CheckOutPage;
import SoftwareTesting.pageObjects.ConformPage;
import SoftwareTesting.pageObjects.LandingPage;
import SoftwareTesting.pageObjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl  extends BaseTest{
	public LandingPage LoginPage;
	public ProductCatalogue ProductCatalogues;
	public CheckOutPage CheckOutPage;
	public ConformPage ConformPage;
	 String Country = "British Indian Ocean Territory";
		String Cvv = "123654";
	 @Given("I landed on the Ecommerce page")
	 public void i_land_on_the_Ecommerce_page() throws IOException { 
		 LoginPage = 	 lanchapplaication();	 
	 }
	 
	 @Given ("Login with username {string} pasword {string}")
	  public void login_with_username_pasword(String username, String password) {
	  ProductCatalogues = LoginPage.LoginApplication(username, password);
	  
	 }
	 
	 @When ("I add product {string} to card")
	 public void i_add_product_to_cart(String productName) throws InterruptedException {
		 
		 ProductCatalogues.addProductToCart(productName);
			 
	 }
	 
	 @And ("checkout {string} and submit the order") 
	 public void checkout_and_submit_order(String productname) throws InterruptedException {
		 CartPage Cartpage = ProductCatalogues.GotoCart();
			CheckOutPage = Cartpage.CheckOut();
			CheckOutPage.inputValues(Country, Cvv);
			 ConformPage = CheckOutPage.PalceOrder();
	 }
	 
	 @Then ("{string} message is dispalyed on the conformation page")
	 public void mseeage_displayed_conformationpage(String message) throws InterruptedException {
		 String confomMsg = ConformPage.ConformationText();
			Thread.sleep(1000);
			Assert.assertTrue(confomMsg.equalsIgnoreCase(message));
		 
		 
	 }
	 
	 @Then("{string} message is dispalyed")
	    public void error_message_is_displayed(String expectedMessage) {
		 Assert.assertEquals(expectedMessage, LoginPage.ErrorMessage());
	    }
	 
	

}
