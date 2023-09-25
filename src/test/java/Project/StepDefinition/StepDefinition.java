package Project.StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import Project.BaseTestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.LoginPage;
import pageObjects.ProductCataloguePage;
import pageObjects.ShippingDetails;


public class StepDefinition extends BaseTest{
public LoginPage LoginPage;
public ProductCataloguePage ProductCataloguePage;
public CartPage CartPage;   
public ShippingDetails ShippingDetails;  
public ConfirmationPage ConfirmationPage ;  

	@Given("I landed on the Ecommerce page")
	public void I_landed_on_the_Ecommerce_page() throws IOException 
	{ 
		LoginPage= launchBrowser();
	}   
	
	@Given("^I must be logged in username (.+) and password (.+)$")
	public void I_must_be_logged_in_username_and_password (String username, String password)
	{
		ProductCataloguePage = LoginPage.login(username,password);
	}
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName)
	{
		CartPage = ProductCataloguePage.selectItem(productName);	
	}  	
	@When("^I verify the (.+) add it to checkout$")
	public void I_verify_the_product_add_it_to_checkout(String productName)
	{
		Boolean match = CartPage.confirmProducts(productName);		
		 Assert.assertTrue(match);     
		 ShippingDetails =  CartPage.clickOnCheckout();
		 ShippingDetails.enterCountry("India"); 
		 ConfirmationPage =  ShippingDetails.clickOnSubmit();
	}
	@Then("^I verify the (.+) is displayed or not$") 
	public void I_verify_the_message_is_displayed_or_not(String text)
	{
		String confirmationText= ConfirmationPage.getText();
		Assert.assertEquals(confirmationText, text);
		driver.close();
	}
	@Then("^I verify the (.+) is clearly displayed or not$")
	public void I_verify_the_text_is_clearly_displayed_or_not(String text)
	{
		Assert.assertEquals(text, LoginPage.getErrorMessage());
		driver.close();
	}
	
}
