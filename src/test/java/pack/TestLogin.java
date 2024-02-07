package pack;

import java.time.Duration;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import browsers.Browsers;
import date.Datepp;
import pageobjectslocators.AccountPage;
import pageobjectslocators.HomePage;
import pageobjectslocators.LoginPage;

public class TestLogin extends Datepp {
	
public	WebDriver driver;

LoginPage loginpage;
	
	@BeforeMethod
	public void open() {
		
		Browsers bro = new Browsers();
		bro.propFile();
		
		driver = Browsers.diff(Browsers.properties.getProperty("browser"));
		
		HomePage hp = new HomePage(driver);
		loginpage = hp.navigateToLoginPage();
		//hp.myaccountclick();
		//hp.loginclick();
		
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		
	}
	
	@AfterMethod
	public void close() {
		
		driver.quit();
		
	}
	
	@Test(priority=1,dataProvider="data")
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		LoginPage lp = new LoginPage(driver);
		AccountPage ap = new AccountPage(driver);
		
		lp.entercredentials(email, password);
		//lp.it(email);
		//lp.ip(password);
		//lp.lc();
		
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		Assert.assertTrue(ap.cm());
		
	}
	
	@DataProvider
	public Object[][] data() {
		
		Object[][] data11 = exceldata("Sheet1");
		
		return data11;
		
	}
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		
		LoginPage lp = new LoginPage(driver);
		AccountPage ap = new AccountPage(driver);
		
		lp.entercredentials(main()+"@gmail.com", Browsers.properties2.getProperty("invalidpassword"));
		
		//----------------------
		
		//lp.it(main()+"@gmail.com");
		//lp.ip(Browsers.properties2.getProperty("invalidpassword"));
		//lp.lc();//click on login button
		//-----------------------------------
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(main()+"@gmail.com");
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(Browsers.properties2.getProperty("invalidpassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		Assert.assertTrue(ap.wm().contains(Browsers.properties2.getProperty("warningmessage")));
		
	}
	
	@Test(priority=3)
	public void loginWithInvalidEmailAndValidPassword() {
		
		AccountPage ap = new AccountPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		lp.entercredentials(main()+"@gmail.com", Browsers.properties.getProperty("password"));
		//-------------------------
		//lp.it(main()+"@gmail.com");
		//lp.ip(Browsers.properties.getProperty("password"));
		//lp.lc();
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(main()+"@gmail.com");
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(Browsers.properties.getProperty("password"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		Assert.assertTrue(ap.wm().contains(Browsers.properties2.getProperty("warningmessage")));
		//driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText()
	}
	
	@Test(priority=4)
	public void loginWithValidEmailAndInvalidPassword() {
		
		AccountPage ap = new AccountPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		lp.entercredentials(Browsers.properties.getProperty("email"), Browsers.properties2.getProperty("invalidpassword"));
		//---------------------------------
		//lp.it(Browsers.properties.getProperty("email"));
		//lp.ip(Browsers.properties2.getProperty("invalidpassword"));
		//lp.lc();
		//--------------------------------------
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(Browsers.properties.getProperty("email"));
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(Browsers.properties2.getProperty("invalidpassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		Assert.assertTrue(ap.wm().contains(Browsers.properties2.getProperty("warningmessage")));
		
	}
	
	@Test(priority=5)
	public void loginWithNotProvidingAnyCredentials() {
		
		AccountPage ap = new AccountPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		lp.entercredentials(" ", " ");
		//----------------------
		//lp.it("");
		//lp.ip("");
		//lp.lc();
		//--------------------------------------
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("");//we can delete these statement
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("");//we can delete these statement
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	
		Assert.assertTrue(ap.wm().contains(Browsers.properties2.getProperty("warningmessage")));
		
	}

}

