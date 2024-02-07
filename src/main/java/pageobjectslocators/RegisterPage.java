package pageobjectslocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
			
			public RegisterPage (WebDriver driver) {
				
				this.driver = driver;
				
				PageFactory.initElements(driver, this);
				
				}
			
			@FindBy(css="#input-firstname")
			private WebElement firstname;
			
			@FindBy(xpath="//*[@id=\"input-lastname\"]")
			private WebElement lastname1;
			
			@FindBy(xpath="//*[@id=\"input-email\"]")
			private WebElement inputemail;
			
			@FindBy(xpath="//*[@id=\"input-telephone\"]")
			private WebElement inputtelephone;
			
			@FindBy(xpath="//*[@id=\"input-password\"]")
			private WebElement password1;
			
			@FindBy(xpath="//*[@id=\"input-confirm\"]")
			private WebElement confirmpassword;
			
			@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
			private WebElement privacipolicy;
			
			@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
			private WebElement continuebutton;
			
			@FindBy(css="div[id='content'] h1")
			private WebElement registermessage;
			
			@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
			private WebElement newsletter;
			
			@FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
			WebElement alreadyreg;
			
			//warning messages------------------------------------------
			//1
			@FindBy(xpath="//*[@id=\"account\"]/div[2]/div/div")
			WebElement firstnwarn;
			//2
			@FindBy(xpath="//*[@id=\"account\"]/div[3]/div/div")
			WebElement lastnwarn;
			//3
			@FindBy(xpath="//*[@id=\"account\"]/div[4]/div/div")
			WebElement emailwarn;
			//4
			@FindBy(xpath="//*[@id=\"account\"]/div[5]/div/div")
			WebElement telepwarn;
			//5
			@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
			WebElement passwarn;
			//6
			@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
			WebElement disp;
			//7
			@FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
			WebElement privpol;
			
			//------------------------------------------
			
			public void fn(String name) {
				
				firstname.sendKeys(name);
				
		}
			
			public void ln(String lastname) {
				
				lastname1.sendKeys(lastname);
				
			}
			
			public void em(String email) {
				
				inputemail.sendKeys(email);
				
			}
			
			public void tel(String telephone) {
				
				inputtelephone.sendKeys(telephone);
				
			}
			
			public void pass(String password) {
				
				password1.sendKeys(password);
				
			}
			
			public void conpass(String password) {
				
				confirmpassword.sendKeys(password);
				
			}
			
			public void pp() {
				
				privacipolicy.click();
				
			}
			
			public void conbutt() {
				
				continuebutton.click();
				
			}

			public String regmess() {
	
				String rm = registermessage.getText();
				return rm;
				
			}
			
			public void newsl() {
				
			newsletter.click();
			
			}
			

			public String alrreg() {
				
			return alreadyreg.getText();
			
			}
		//-----------------------------------------	
		//warning messages	
			public String fnw() {
				
			return	firstnwarn.getText();
				
					}
			
			public String lnw() {
				
			return	lastnwarn.getText();
				
			}
			
			public String emw() {
				
				return emailwarn.getText();
				
			}
			
			public String tw() {
				
				return telepwarn.getText();
				
			}
			
			public String pw() {
				
				return passwarn.getText();
				
			}
			
			public boolean diss() {
				
			return	disp.isDisplayed();
				
			}
			
			public String pripolp() {
				
				return privpol.getText();
				
			}
			//---------------------------
			public void enterregistercredentials(String name,String lastname,String email,String telephone,String password) {
				
				firstname.sendKeys(name);
				lastname1.sendKeys(lastname);
				inputemail.sendKeys(email);
				inputtelephone.sendKeys(telephone);
				password1.sendKeys(password);
				confirmpassword.sendKeys(password);
				privacipolicy.click();
				continuebutton.click();
				
			}
			
			public void enterregistercredentialsallfields(String name,String lastname,String email,String telephone,String password) {
				
				firstname.sendKeys(name);
				lastname1.sendKeys(lastname);
				inputemail.sendKeys(email);
				inputtelephone.sendKeys(telephone);
				password1.sendKeys(password);
				confirmpassword.sendKeys(password);
				newsletter.click();
				privacipolicy.click();
				continuebutton.click();
				
			}
			
			public void enterregistercredentialsexistingmail(String name,String lastname,String email,String telephone,String password) {
				
				firstname.sendKeys(name);
				lastname1.sendKeys(lastname);
				inputemail.sendKeys(email);
				inputtelephone.sendKeys(telephone);
				password1.sendKeys(password);
				confirmpassword.sendKeys(password);
				newsletter.click();
				privacipolicy.click();
				continuebutton.click();
				
			}
			
			
	}
