
package SoftwareTesting.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SoftwareTesting.TestComponents.BaseTest;
import SoftwareTesting.pageObjects.CartPage;
import SoftwareTesting.pageObjects.CheckOutPage;
import SoftwareTesting.pageObjects.ConformPage;
import SoftwareTesting.pageObjects.OrdersPage;
import SoftwareTesting.pageObjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productNmae = "ZARA COAT 3";
	@Test(dataProvider = "getdata" , groups = {"Purchase"})
	public void submitOrder(HashMap<String , String> input) throws IOException, InterruptedException {
		
		String Country = "British Indian Ocean Territory";
		String Cvv = "123654";
//		LandingPage LoginPage = lanchapplaication();
		
		ProductCatalogue ProductCatalogues = LoginPage.LoginApplication(input.get("email"), input.get("password"));
		
		ProductCatalogues.addProductToCart(input.get("product"));
		CartPage Cartpage = ProductCatalogues.GotoCart();
		boolean check = Cartpage.checkItemsInCart(input.get("product"));
		CheckOutPage CheckOutPage = Cartpage.CheckOut();
		CheckOutPage.inputValues(Country, Cvv);
		ConformPage ConformPage = CheckOutPage.PalceOrder();
		String confomMsg = ConformPage.ConformationText();
		Thread.sleep(1000);
		Assert.assertTrue(confomMsg.equalsIgnoreCase("Thankyou for the order."));
		System.out
				.println(driver.findElement(By.cssSelector("label[class ='ng-star-inserted']:first-child")).getText());

	}
	
//	@Test (dependsOnMethods = {"submitOrder"})
//	public void orderHistoryTest(HashMap<String , String> input) throws InterruptedException {
//		
//		ProductCatalogue ProductCatalogues = LoginPage.LoginApplication("testing1212@gmail.com", "Naga@121");
//		
//		OrdersPage OrdersPage= ProductCatalogues.GotoOrderHistory();
//		
//	Assert.assertTrue(OrdersPage.checkItemsOrderHistory(input.get("product")));
//		
//		
//	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest() throws InterruptedException {

	    ProductCatalogue productCatalogue =
	        LoginPage.LoginApplication("testing1212@gmail.com", "Naga@1212");

	    OrdersPage ordersPage = productCatalogue.GotoOrderHistory();

	    Assert.assertTrue(
	        ordersPage.checkItemsOrderHistory(productNmae)
	    );
	}

	
	
	
//	
//	@DataProvider
//	public Object[][] getdata() {
//		
//		return new Object[][] {{"testing1212@gmail.com","Naga@1212", "ZARA COAT 3"}, {"testing121212@gmail.com", "Naga@1212", "ADIDAS ORIGINAL"}};
//	}
	
	
	//HashMaps
	
	
	@DataProvider
	public Object[][] getdata() throws IOException{
		
//		HashMap<Object, Object> map = new HashMap<Object , Object>();
//		map.put("Email", "testing1212@gmail.com");
//		map.put("pasword", "Naga@1212");
//		map.put("product", "ADIDAS ORIGINAL");
//		
//		HashMap<Object, Object> map2 = new HashMap<Object , Object>();
//		map2.put("Email", "testing121212@gmail.com");
//		map2.put("pasword", "Naga@1212");
//		map2.put("product", "ZARA COAT 3");
		 List<HashMap<String , String >> data =   getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//SoftwareTesting//data//PurchaseOrder.json");
		
		return new  Object[][] {{data.get(0)} ,{data.get(1)}};
		
	}
	

}
