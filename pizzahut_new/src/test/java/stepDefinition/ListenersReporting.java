package stepDefinition;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ListenersReporting implements ITestListener {
	ExtentReports extent;
	ExtentTest test;

	public void onStart(ITestContext context) {
		System.out.println("Started execution for " + context.getName());
		ExtentSparkReporter html = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/test-output/ExtentReportFile.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	public void onTestStart(ITestResult result) {
		System.out.println("execution for test started  " + result.getName());
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed  " + result.getName());
		test.log(Status.PASS, "TETS HAS PASSED");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed " + result.getName());
		test.log(Status.FAIL, "TETS HAS FAILED");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped " + result.getName());
		test.log(Status.SKIP, "TETS HAS SKIPPED");
	}

	public void onFinish(ITestContext context) {
		System.out.println("execution done for " + context.getName());
		extent.flush();
	}
}