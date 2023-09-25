package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonMethods.CommonMethods;

public class LoginPage extends CommonMethods{
WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
By username = 	By.id("userEmail");
By password =  By.id("userPassword");
By loginButton = By.id("login"); 
By ErrorMessage = By.cssSelector("[class*='flyInOut']");
public ProductCataloguePage login(String userName,String passWord)
{	
	driver.findElement(username).sendKeys(userName);
	driver.findElement(password).sendKeys(passWord);
	driver.findElement(loginButton).click();
	return new ProductCataloguePage(driver);
}

public void launchUrl()
{
 driver.get("https://rahulshettyacademy.com/client/");
}

public String getErrorMessage()
{
	waitForElementToAppear(ErrorMessage);
	String ErrorMsg = driver.findElement(ErrorMessage).getText();
	return ErrorMsg;
}

}
