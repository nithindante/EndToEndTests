package Project.SampleProject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import JSONData.DataForJson;
import Project.BaseTestComponents.BaseTest;
import Project.BaseTestComponents.Retry;
import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.LoginPage;
import pageObjects.OrderHistoryPage;
import pageObjects.ProductCataloguePage;
import pageObjects.ShippingDetails;

public class SubmitOrder extends BaseTest{

	@Test(groups="Purchase Order",dataProvider="getData")
	public void endToEndTests(HashMap<String, String> inputData) throws  IOException 
	{		 
		ProductCataloguePage ProductCataloguePage = LoginPage.login(inputData.get("email"), inputData.get("password"));
		CartPage CartPage= ProductCataloguePage.selectItem(inputData.get("product"));	
		 Boolean match = CartPage.confirmProducts(inputData.get("product"));		
		 Assert.assertTrue(match); 
		 ShippingDetails ShippingDetails =  CartPage.clickOnCheckout();
		 ShippingDetails.enterCountry("India");
		 ConfirmationPage ConfirmationPage =  ShippingDetails.clickOnSubmit();
		 String confirmationText= ConfirmationPage.getText();
		Assert.assertEquals(confirmationText, "THANKYOU FOR THE ORDER.");
	}
	 
	@Test(dependsOnMethods="endToEndTests" )
	public void VerifyProduct() throws  IOException, InterruptedException 
	{		
		ProductCataloguePage ProductCataloguePage = LoginPage.login("nithinrajkumar@gmail.com", "Sreekuty1@");
		OrderHistoryPage OrderHistoryPage = ProductCataloguePage.clickOnOrders();
		String itemName = OrderHistoryPage.getProductConfirmation("IPHONE 13 PRO");
		Assert.assertEquals(itemName, "iphone 13 pro"); 
	}
	 
	@DataProvider
	public Object[][] getData() throws IOException
	{
		DataForJson DataForJson = new DataForJson();
		List<HashMap<String, String>> inputData = DataForJson.getDataForJson();	

		return new Object [][] { {inputData.get(0)},{inputData.get(1)}};
	}
	
	
	}   

