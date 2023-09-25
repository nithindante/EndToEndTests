package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.CommonMethods;

public class OrderHistoryPage extends CommonMethods{
WebDriver driver;
By OrdersList = By.xpath("//tr//td[2]");
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public List<WebElement> ordersList() throws InterruptedException
	{
		waitForElementToAppear(OrdersList);
		List<WebElement> ListOfOrders = driver.findElements(OrdersList);
		return ListOfOrders;
	}
	
	public String getProductConfirmation(String productName) throws InterruptedException
	{
		WebElement selectedItem = ordersList().stream().filter(product->product.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		String product = selectedItem.getText(); 
		return product;
	}
	
}
