package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Listeners implements ITestListener {
	
	WebDriver driver;
	
	ExtentReports extRep;
	
	ExtentTest fina;
	
	@Override
	public void onStart(ITestContext context) {
		
		extRep = Reporters.report();
		
		//System.out.println("execution started");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();//mozi global da se napraj
		
		fina = extRep.createTest(testName);
		fina.log(Status.INFO, "test case started");
		
		System.out.println(testName+"test case started");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		
		fina.log(Status.PASS, "test case success");
		
		System.out.println(testName+"test case success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		
		WebDriver driver=null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File err = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ss = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		
		try {
			FileHandler.copy(err, new File(ss));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fina.addScreenCaptureFromPath(ss);
		
		fina.log(Status.INFO, result.getThrowable());
		
		//System.out.println(testName+" test case fail");
		
		fina.log(Status.FAIL, " test case fail");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getName();
		
		fina.log(Status.INFO, result.getThrowable());
		
		fina.log(Status.SKIP, testName+" is skipped");
		
	}


	@Override
	public void onFinish(ITestContext context) {
		
		String testName = context.getName();
		
		System.out.println(testName);
		
		extRep.flush();
		
		String file = System.getProperty("user.dir")+"\\test-output\\report.html";
		File file1 = new File(file);
		
		try {
			Desktop.getDesktop().browse(file1.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
