package Project.BaseTestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports Reports = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentReport = new ThreadLocal();
	 @Override 
	 public void onTestStart(ITestResult result)
	 {
		 test = Reports.createTest(result.getMethod().getMethodName());
		 extentReport.set(test);
	 }
	 @Override
	 public void onTestSuccess(ITestResult result)
	 {
		extentReport.get().log(Status.PASS, "Test passed");
		 
	 }
	 @Override
	 public void onTestFailure(ITestResult result)
	 {
	 
		 extentReport.get().fail(result.getThrowable());
	 
	 try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 String filePath = null; 
	 try {
		 filePath = getScreenshot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 extentReport.get().addScreenCaptureFromPath(filePath);
	 }
	 @Override
	 public void onFinish(ITestContext Context)
	 {
		 Reports.flush();
		 
	 }
}
