package pageobjectslocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"search\"]/input")
	private WebElement enterproduct;
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button/i")
	private WebElement click;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")
	private WebElement display;
	
	@FindBy(xpath="//*[@id=\"content\"]/h2")
	private WebElement act;
	
	@FindBy(xpath="//*[@id=\"content\"]/h2")
	private WebElement nopr;
	
	@FindBy(xpath="//*[@id=\"search\"]/input")
	private WebElement sk;
	
	
	//------------------------------------------------------
	public void ep(String product) {
		
		enterproduct.sendKeys(product);
		
	}
	
	public void cl() {
		
		click.click();
	}

	public boolean display() {
	
		return display.isDisplayed();
}
	
	public String actual() {
		
		return act.getText();
}
	
	
	public String not() {
		
		return nopr.getText();
		
		
}
	
	public void not11() {
		
		
		sk.getText();
}
	//-----------------------------
	
	public void search(String product) {
		
		enterproduct.sendKeys(product);
		click.click();
	}
	
	public void invalidsearch(String product) {
		
		sk.getText();
		click.click();
	}


}
