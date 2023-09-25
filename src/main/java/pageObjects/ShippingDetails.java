package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.CommonMethods;

public class ShippingDetails extends CommonMethods{
WebDriver driver;
	public ShippingDetails(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	By country = By.xpath("//input[@placeholder=\"Select Country\"]");
	By suggestionsbox = By.xpath("//div[@class='form-group']//section");
	By suggestions= By.xpath("//span[@class='ng-star-inserted']");
	By submitbutton = By.cssSelector(".action__submit");
	public void enterCountry(String countryname)
	{
		driver.findElement(country).sendKeys(countryname);
		waitForElementToAppear(suggestionsbox);
		List<WebElement> countries = driver.findElements(suggestions);
		for(WebElement suggestion:countries)    
		{ 
			if(suggestion.getText().equalsIgnoreCase(countryname))
			{ 
				suggestion.click();
			} 
		}  
	}
	public ConfirmationPage clickOnSubmit()
	{
		driver.findElement(submitbutton).click();
		return new ConfirmationPage(driver);
	}
}
