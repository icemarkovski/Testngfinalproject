package pageobjectslocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	LoginPage loginpage;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	private WebElement inputtext;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	private WebElement inputpassword;

	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginclick;
	//---------------------------------
	public void it(String email) {
		
		inputtext.sendKeys(email);
		
	}
	
	public void ip(String password) {
		
		inputpassword.sendKeys(password);
		
	}
	
	public void lc() {
		
		loginclick.click();
	}
	//------------------------------
	public LoginPage entercredentials(String email, String password) {
		
		inputtext.sendKeys(email);
		
		inputpassword.sendKeys(password);
		
		loginclick.click();
		
		return  new LoginPage(driver);
	}
	
}
