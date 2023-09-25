package Project.SampleProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import Project.BaseTestComponents.Retry;
import Project.BaseTestComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.LoginPage;
import pageObjects.ProductCataloguePage;
import pageObjects.ShippingDetails;

public class ErrorValidation extends BaseTest {
	@Test(groups="Error Validation",retryAnalyzer=Retry.class)
	public void LoginErrorChecking() throws IOException
	{ 
	LoginPage.login("nithinrajkumarr@gmail.com", "Sreekuty1@");
	Assert.assertEquals("Incorrect email or password.", LoginPage.getErrorMessage());
	System.out.println("Success");
	}   
	

	@Test (groups="Error Validation")
	public void ProductCatalogueErrorChecking() throws  IOException {		
		ProductCataloguePage ProductCataloguePage = LoginPage.login("nithinrajkumar@gmail.com", "Sreekuty1@");
		CartPage CartPage= ProductCataloguePage.selectItem("IPHONE 13 PRO");	
		 Boolean match = CartPage.confirmProducts("iphone 13 pro");		
		 Assert.assertTrue(match); 	 	  
		 System.out.println("Success");
} 
} 
