package ee.ut.vl.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class MyArchivePage {

	private WebDriver driver;
	
	@FindBy(id = "total")
	private WebElement totalPastes;
	
	@FindBy(css = ".pastelink")
	private WebElement pasteName;
	
	@FindBy(id = "logoutbutton")
	private WebElement logoutButton;
	
	@FindBy(css = ".syntax")
	private WebElement pasteSyntax;
	
	@FindBy(css = ".exposure")
	private WebElement pasteExposure;
	
	public MyArchivePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logOut(){
		logoutButton.click();
	}
	
	public String getTotalPastes() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(totalPastes));
		return totalPastes.getText();
	}
	
	public String getNewestPasteSyntax() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteSyntax));
		return pasteSyntax.getText();
	}
	
	public String getNewestPasteExposure() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteExposure));
		return pasteExposure.getText();
	}
	
	public String getNewestPasteName() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteName));
		return pasteName.getText();
	}
	
	public PasteViewPage goViewNewestPaste() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteName));
		pasteName.click();		
		return PageFactory.initElements(driver, PasteViewPage.class);
	}
	
	public static MyArchivePage navigateTo(WebDriver driver) {
		driver.get("http://makbin-heroku.herokuapp.com/mypastes");
		return PageFactory.initElements(driver, MyArchivePage.class);
	}
	
}