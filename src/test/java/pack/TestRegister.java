package pack;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import browsers.Browsers;
import date.Datepp;
import pageobjectslocators.HomePage;
import pageobjectslocators.RegisterPage;

public class TestRegister extends Datepp {
	//4 test cases
	public WebDriver driver;
	
	RegisterPage registerpage;
	
	@BeforeMethod
	public void open() {
		
		Browsers bro = new Browsers();
		bro.propFile();
		
		driver = Browsers.diff(bro.properties.getProperty("browser"));
		
		HomePage hp = new HomePage(driver);
		
		registerpage = 	hp.navigatetoregister();
		//hp.myaccountclick();
		//hp.registerclick();
		//---------------------------
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
	
	}
	//----------------------------------------------------------------
	@AfterMethod
	public void close() {
		
		driver.quit();
		
		}
	//1-----------------------------------------------------------
	@Test(priority=1)
	public void verifyRegisteringOnlyWithMandatoryFields() {
		
		RegisterPage rp = new RegisterPage(driver);
		rp.enterregistercredentials(Browsers.properties2.getProperty("name"), Browsers.properties2.getProperty("lastname"), main()+"@gmail.com", Browsers.properties2.getProperty("telephone"),Browsers.properties.getProperty("password"));
		//rp.fn(Browsers.properties2.getProperty("name"));
		//rp.ln(Browsers.properties2.getProperty("lastname"));
		//rp.em(main()+"@gmail.com");
		//rp.tel(Browsers.properties2.getProperty("telephone"));
		//rp.pass(Browsers.properties.getProperty("password"));
		//rp.conpass(Browsers.properties.getProperty("password"));
		//rp.pp();
		//rp.conbutt();
		//----------------
			//driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys(Browsers.properties2.getProperty("name"));
			//driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(Browsers.properties2.getProperty("lastname"));
			//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(main()+"@gmail.com");
			//driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(Browsers.properties2.getProperty("telephone"));
			//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(Browsers.properties.getProperty("password"));
			//driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(Browsers.properties.getProperty("password"));
			//driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
			//driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
			//String act = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
			
			String exp = Browsers.properties2.getProperty("createdaccount");
			Assert.assertEquals(rp.regmess(),exp);
			
	}
	//2--------------------------------------------------------------
	@Test(priority=2)
	public void verifyRegisteringByProvidingAllFields() {
		
		RegisterPage rp = new RegisterPage(driver);
		rp.enterregistercredentialsallfields(Browsers.properties2.getProperty("name"), Browsers.properties2.getProperty("lastname"), main()+"@gmail.com", Browsers.properties2.getProperty("telephone"),Browsers.properties.getProperty("password"));
//		rp.fn(Browsers.properties2.getProperty("name"));
//		rp.ln(Browsers.properties2.getProperty("lastname"));
//		rp.em(main()+"@gmail.com");
//		rp.tel(Browsers.properties2.getProperty("telephone"));
//		rp.pass(Browsers.properties.getProperty("password"));
//		rp.conpass(Browsers.properties.getProperty("password"));
//		rp.newsl();
//		rp.pp();
//		rp.conbutt();
		
			//driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys(Browsers.properties2.getProperty("name"));
			//driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(Browsers.properties2.getProperty("lastname"));
			//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(main()+"@gmail.com");
			//driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(Browsers.properties2.getProperty("telephone"));
			//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(Browsers.properties.getProperty("password"));
			//driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(Browsers.properties.getProperty("password"));
			//driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
			//driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
			//String act = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		
			String exp = Browsers.properties2.getProperty("createdaccount");
			Assert.assertEquals(rp.regmess(),exp);
			
	}
	//3--------------------------------------------------------------
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAdress() {
		
		RegisterPage rp = new RegisterPage(driver);
		rp.enterregistercredentialsexistingmail(Browsers.properties2.getProperty("name"), Browsers.properties2.getProperty("lastname"),Browsers.properties.getProperty("email") , Browsers.properties2.getProperty("telephone"),Browsers.properties.getProperty("password"));
//		rp.fn(Browsers.properties2.getProperty("name"));
//		rp.ln(Browsers.properties2.getProperty("lastname"));
//		rp.em(Browsers.properties.getProperty("email"));
//		rp.tel(Browsers.properties2.getProperty("telephone"));
//		rp.pass(Browsers.properties.getProperty("password"));
//		rp.conpass(Browsers.properties.getProperty("password"));
//		rp.newsl();
//		rp.pp();
//		rp.conbutt();
		//	driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys(Browsers.properties2.getProperty("name"));
		//	driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(Browsers.properties2.getProperty("lastname"));
		//	driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(Browsers.properties.getProperty("email"));
		//	driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(Browsers.properties2.getProperty("telephone"));
		//	driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(Browsers.properties.getProperty("password"));
		//	driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(Browsers.properties.getProperty("password"));
		//	driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		//	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		//	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
			
		//String act = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
			
		String exp = Browsers.properties2.getProperty("registeredaccount");
		Assert.assertEquals(rp.alrreg(),exp);
			
	}
	//4----------------------------------------------------------------
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutProvidingAnyDetails() {
		
			RegisterPage rp = new RegisterPage(driver);
			rp.conbutt();
//			driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("");//we can delete these statement
//			driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("");
//			driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("");
//			driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("");
//			driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("");
//			driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("");
//			driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
//			driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
//			driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
			
			//1--------------------------------------------------
			//String act = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
			String exp = Browsers.properties2.getProperty("firstnamewarning");
			Assert.assertEquals(rp.fnw(),exp);
			//2-----------------------------------------
			//String act1 = driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText();
			String exp1 = Browsers.properties2.getProperty("lastnamewarning");
			Assert.assertEquals(rp.lnw(),exp1);
			//3---------------------------------------
			//String act2 = driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText();
			String exp2 = Browsers.properties2.getProperty("emailwarning");
			Assert.assertEquals(rp.emw(),exp2);
			//4------------------------------------------
			//String act3 = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText();
			String exp3 = Browsers.properties2.getProperty("telephonewarning");
			Assert.assertEquals(rp.tw(),exp3);
			//5------------------------------------------------
			//String act4 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText();
			String exp4 = Browsers.properties2.getProperty("passwordwarning");
			Assert.assertEquals(rp.pw(),exp4);
			//6--------------------------------------------------
			//WebElement act5 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div"));
			Assert.assertTrue(rp.diss());
			//7----------------------------------
			//String act6 = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
			String exp6 = Browsers.properties2.getProperty("privacypolicywarning");
			Assert.assertEquals(rp.pripolp(),exp6);
	}

}
