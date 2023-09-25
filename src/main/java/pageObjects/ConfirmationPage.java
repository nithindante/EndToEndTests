package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonMethods.CommonMethods;

public class ConfirmationPage extends CommonMethods{

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
By confirmationText= By.cssSelector("h1");

public String getText()
{
	waitForElementToAppear(confirmationText);
	String text = driver.findElement(confirmationText).getText();
	return text;
}
}
