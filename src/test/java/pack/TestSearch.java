package pack;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browsers.Browsers;
import date.Datepp;
import pageobjectslocators.SearchPage;

public class TestSearch extends Datepp {
	
	public WebDriver driver;
	
	@BeforeTest
	public void open() {
		
		Browsers bro = new Browsers();
		bro.propFile();
		
		driver = Browsers.diff(Browsers.properties.getProperty("browser"));
		
	}
	
	@AfterTest
	public void close() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		SearchPage sp = new SearchPage(driver);
		sp.search(Browsers.properties2.getProperty("product"));
		//sp.ep(Browsers.properties2.getProperty("product"));
		//sp.cl();
		
		//driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(Browsers.properties2.getProperty("product"));
		//driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i")).click();
		
		//WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a"));
		Assert.assertTrue(sp.display());
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvaldProduct() {
		
		SearchPage sp = new SearchPage(driver);
		sp.search(Browsers.properties2.getProperty("invalidproduct"));
		//sp.ep(Browsers.properties2.getProperty("invalidproduct"));
		//sp.cl();
		//driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(Browsers.properties2.getProperty("invalidproduct"));
		//driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i")).click();
		
		//String act = driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
		String exp = Browsers.properties2.getProperty("productmessage");
		Assert.assertEquals(sp.actual(), exp);
		
	}
	
	@Test(priority=3)
	public void verifySearchWithoutProvidinAnyProduct() {
		
		SearchPage sp = new SearchPage(driver);
		
		sp.invalidsearch(null);
		//sp.not11();
		//sp.cl();
		
		//driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("");
		//driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i")).click();
		//String act = driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
		String exp = Browsers.properties2.getProperty("productmessage");
		Assert.assertEquals(sp.not(), exp);
		
	}

}
