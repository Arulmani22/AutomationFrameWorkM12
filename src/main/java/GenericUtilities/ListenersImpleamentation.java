package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListeners interface of TestNG
 * @author Arulmani P
 */
public class ListenersImpleamentation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "---- Test Start ----");
		
		//add @Test to extent report
		test = report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "---- Test Pass ----");
		test.log(Status.PASS, methodName+ "---- Test Pass ----");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "---- Test Fail ----");
		
		//Log the Fail status to extent Report
		test.log(Status.FAIL, methodName+ "---- Test Fail ----");
		
		
		SeleniumUtilites s = new SeleniumUtilites();
		JavaUtility j = new JavaUtility();
		String screenshotName = methodName+"-"+j.getDate();
		try 
		{
		String path = s.captureTheScreenShot(BaseClass.sDriver, screenshotName);
		
			//Attach screenshot to extent reports
			test.addScreenCaptureFromPath(path);
		
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "---- Test Skipp ----");
		
		//log the skip status to extent report
		test.log(Status.SKIP, methodName+ "---- Test Skipp ----");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("---- Suite execution Strated ----");
		
		//Extent Report Configuration
		
	ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
	rep.config().setDocumentTitle("Execution Report");
	rep.config().setReportName("Vtiger execution report");
	rep.config().setTheme(Theme.DARK);

	report = new ExtentReports();
	report.attachReporter(rep);
	report.setSystemInfo("Base platform", "Windows");
	report.setSystemInfo("Base Browser", "Chrome");
	report.setSystemInfo("Base url", "http://localhost:8888");
	report.setSystemInfo("Reporter Name", "Arulmani P");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("---- Suite execution Finish ----");
		//Generate extent report
		report.flush();
		
	}

	
}
