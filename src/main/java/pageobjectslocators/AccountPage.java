package pageobjectslocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	
	}
	//1
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	private WebElement confirmmessage;
	
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	private WebElement warningmessage;
	
	
	//1
	public boolean cm() {
		
		
		boolean conmess = confirmmessage.isDisplayed();
		
		return conmess;
	}
	
	public String wm() {
		
		
		String warnmess = warningmessage.getText();
		
		return warnmess;
	}
	

}
