package Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	 public static ExtentReports getReportObject()
	{
		File file = new File(System.getProperty("user.dir")+"//reports//index.html");
		ExtentSparkReporter Reporter = new ExtentSparkReporter(file);
		Reporter.config().setReportName("Web Automation Results ");
		Reporter.config().setDocumentTitle("Extent Reports");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(Reporter);
		return reports;
		 
	} 
}
