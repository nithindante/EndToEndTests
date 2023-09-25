package Project.BaseTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.jar.asm.TypeReference;
import pageObjects.LoginPage;


public class BaseTest {
public WebDriver driver;
public LoginPage LoginPage;
	public WebDriver initialiseDriver() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream FileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		properties.load(FileInputStream);
		String browserName = (System.getProperty("browser")!=null)?System.getProperty("browser"):properties.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			ChromeOptions Options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			Options.addArguments("headless");
			} 
		 driver= new ChromeDriver(Options);		
		 driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			 driver= new EdgeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			 driver= new FirefoxDriver();
			  
		}
		driver.manage().window().maximize();
		return driver;
	}  
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
	  File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	  FileHandler.copy(source,file); 
	  return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";		
	}
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchBrowser() throws IOException
	{
		driver = initialiseDriver();
		LoginPage = new LoginPage(driver);
		LoginPage.launchUrl();
		return LoginPage;
	}
	@AfterMethod(alwaysRun=true)
	public void browserClose()
	{
		driver.close();
	}

	
}
