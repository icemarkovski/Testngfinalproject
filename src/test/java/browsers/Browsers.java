package browsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import date.Datepp;


public class Browsers {
	
	static WebDriver driver;
	
	public static Properties properties;
	
	public static Properties properties2;
	
	public void propFile() {
		
		properties = new Properties();
		
		properties2 = new Properties();
		
		String prop1 = System.getProperty("user.dir")+"\\src\\main\\java\\prop\\prop.properties";
		
		String prop2 = System.getProperty("user.dir")+"\\src\\main\\java\\prop\\prop1.properties";

		
		File file = new File(prop1);
		
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file2 = new File(prop2);
		
		FileInputStream fis2=null;
		try {
			fis2 = new FileInputStream(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			properties2.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static  WebDriver diff(String browserName) {
	
	//String browserName = "chrome";
	
	if(browserName.equalsIgnoreCase("chrome")) {
					//equalsIgnoreCase - e metod za da ne praj razlika megu golema i mala bukva
		driver = new ChromeDriver();
		
	}
		
	else if(browserName.equalsIgnoreCase("edge")) {
		
		driver = new EdgeDriver();
	}
	
	else if(browserName.equalsIgnoreCase("firefox")) {
		
		driver = new FirefoxDriver();
		
	}
	
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Datepp.IMPLICITLY_TIME));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Datepp.PAGE_LOAD_TIME));
		driver.get(properties.getProperty("url"));

		return driver;
	
	}

}
