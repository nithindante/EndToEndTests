package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.CommonMethods;

public class ProductCataloguePage extends CommonMethods{
WebDriver driver;
public ProductCataloguePage(WebDriver driver) 
{
		super(driver);
		this.driver = driver;
}
By products = By.xpath("//div[@class='card']");
By exactItem = By.cssSelector(".w-10");
By elementToAppear = By.xpath("//div[@class='card']//b");
By popup = By.id("toast-container");
By spinner = By.cssSelector(".ng-animating");
public List<WebElement> productsList()
{
	waitForElementToAppear(elementToAppear);
	List<WebElement> productItems = driver.findElements(products);	 
	return productItems;
}
public CartPage selectItem(String productItem)
{	
	WebElement item = productsList().stream().filter(
			product -> product.findElement(By.xpath("div//h5//b")).getText().equalsIgnoreCase(productItem))
			.findFirst().orElse(null); 
	item.findElement(exactItem).click();
	waitForElementToAppear(popup);
	waitForElementToDisappear(spinner);
	waitForElementToAppear(popup);
	clickOnCart(); 
	return new CartPage(driver);
}

}
