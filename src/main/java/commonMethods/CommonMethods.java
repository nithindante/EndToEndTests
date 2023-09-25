package commonMethods;

import java.time.Duration;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.OrderHistoryPage;

public class CommonMethods {
WebDriver driver;
By cartIcon = By.xpath("//button[@routerlink=\"/dashboard/cart\"]//i");
By OrdersIcon = By.xpath("//button[@routerlink=\"/dashboard/myorders\"]");
	public CommonMethods(WebDriver driver)
	{
		this.driver = driver;		
	}
	
	public void waitForElementToAppear(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementToDisappear(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	public void clickOnCart()
	{
		driver.findElement(cartIcon).click();
	}
	public OrderHistoryPage clickOnOrders() throws InterruptedException
	{
		waitForElementToAppear(OrdersIcon);
		driver.findElement(OrdersIcon).click();
		return new OrderHistoryPage(driver);
	}
}
