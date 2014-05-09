package ee.ut.vl.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(id = "log_in")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public LoginPage typeUsername(String text) {
		username.sendKeys(text);
		return this;
	}

	public LoginPage typePassword(String text) {
		password.sendKeys(text);
		return this;
	}
	
	public PasteAddPage submitLogin() {
		loginButton.click();
		return PageFactory.initElements(driver, PasteAddPage.class);
	}
	
	public LoginPage submitLoginExpectingFailure(){
		loginButton.click();		
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public PasteAddPage loginAs(String username, String password) {
		typeUsername(username);
		typePassword(password);
		return submitLogin();
	}	
	
	public LoginPage failLoginAs(String email, String password) {
		typeUsername(email);
		typePassword(password);
		return submitLoginExpectingFailure();
	}
	
	public static LoginPage navigateTo(WebDriver driver) {
		driver.get("http://makbin-heroku.herokuapp.com");
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
}
