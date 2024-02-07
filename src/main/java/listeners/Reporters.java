package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporters {
	
	public static ExtentReports report() {
	
	ExtentReports extentReport = new ExtentReports();
	
	String rep = System.getProperty("user.dir")+"\\test-output\\report.html";
	
	File file = new File(rep);
	
	ExtentSparkReporter spark = new ExtentSparkReporter(file);
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("Testngfinalproject");
	spark.config().setDocumentTitle("TestNGFP");
	spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	
	extentReport.attachReporter(spark);
	
	Properties prop = new Properties();
	String doc = System.getProperty("user.dir")+"\\src\\main\\java\\prop\\prop.properties";
	File file1 = new File(doc);
	FileInputStream fis = null;
	try {
		fis = new FileInputStream(file1);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//prop.getProperty("url");
	
	extentReport.setSystemInfo("app url", prop.getProperty("url"));
	extentReport.setSystemInfo("app browser", prop.getProperty("browser"));
	extentReport.setSystemInfo("app email", prop.getProperty("email"));
	extentReport.setSystemInfo("app password", prop.getProperty("password"));
	
	extentReport.setSystemInfo("opp system", System.getProperty("os.name"));
	extentReport.setSystemInfo("operator name", System.getProperty("user.name"));
	extentReport.setSystemInfo("java version", System.getProperty("java.version"));

	return extentReport;
	
	
//	extentReport.flush();
//	try {
//		Desktop.getDesktop().browse(file.toURI());
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	
	
	}
	
	

}
