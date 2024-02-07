package pageobjectslocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;

LoginPage loginpage;

RegisterPage registerpage;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	private WebElement MyAccountDropMenu;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private WebElement LoginButton;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	private WebElement RegisterButton;
	
	//--------------------------------
	public void myaccountclick() {
		
		MyAccountDropMenu.click();
		
	}
	//--------------------------------
	public void loginclick() {
		
		LoginButton.click();
		
	}
	//---------------------------------------
	public LoginPage navigateToLoginPage() {
		
		MyAccountDropMenu.click();
		
		LoginButton.click();
		
		return new LoginPage(driver);
		
	}
	//----------------------------
	public void registerclick() {
		
		RegisterButton.click();
		
	}
	//----------------------
	public RegisterPage navigatetoregister() {
		
		MyAccountDropMenu.click();
		RegisterButton.click();
		
		return new RegisterPage(driver);
		
	}
	
	
}
