package SoftwareTesting.Resources;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReporterNG {
	
	
	
	@Test
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("User.dir")+"//reports//index.html";
		
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Result");
		report.config().setDocumentTitle("Test Result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Ganesh Naga");
		
		return extent;
	}

}
