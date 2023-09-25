package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.CommonMethods;

public class CartPage extends CommonMethods{
WebDriver driver;
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}
	By cartHeading = By.xpath("//h1");
	By cartImage = By.xpath("//i/following-sibling::label");
	By itemsInTheCart = By.xpath("//div[@class='cart']//ul");
	By cartItem = By.xpath("//div[@class='cartSection']//h3");
	By checkout = By.xpath("(//li[@class='totalRow'])[3]//button");
	public List<WebElement> cartItems()
	{
		List<WebElement> carts = driver.findElements(cartItem);
		return carts;
	}
public boolean confirmProducts(String productName)
{
	waitForElementToAppear(cartHeading);
	waitForElementToAppear(cartImage);
	waitForElementToAppear(itemsInTheCart);	
	boolean matchFounded = cartItems().stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(productName));	
	return matchFounded;
} 

public ShippingDetails clickOnCheckout()
{
	driver.findElement(checkout).click();
	return new ShippingDetails(driver);
}
}
