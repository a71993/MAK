package ee.ut.vl.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


public class PasteEditPage {
	
private WebDriver driver;
	
	@FindBy(name = "name")
	private WebElement pasteName;
	
	@FindBy(name = "paste")
	private WebElement pasteText;
	
	@FindBy(name = "syntax")
	private WebElement pasteSyntax;
	
	@FindBy(name = "exposure")
	private WebElement pasteExposure;
	
	@FindBy(id = "submitbutton")
	private WebElement saveButton;
	
	@FindBy(id = "myarchive")
	private WebElement myArchiveLink;
	
	@FindBy(id = "otherpastes")
	private WebElement otherPastesLink;
	
	
	public PasteEditPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public PasteEditPage typeNewName(String text) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteName));
		pasteName.clear();
		pasteName.sendKeys(text);
		return this;
	}
	
	public PasteEditPage typeNewPaste(String text) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteText));
		pasteText.clear();
		pasteText.sendKeys(text);
		return this;
	}
	
	public PasteEditPage selectSyntax(String syntax) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteSyntax));
		Select select = new Select(pasteSyntax);
		//languages.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name=\"syntax\"] option[value=\"C++\"]")));
		select.selectByValue(syntax);
		return this;
	}
	
	public PasteEditPage selectExposure(String exposure) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteExposure));
		Select select = new Select(pasteExposure);
		//languages.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name=\"exposure\"] option[value=\"Private\"]")));
		select.selectByValue(exposure);
		return this;
	}
	
	public PasteViewPage submitNewPaste() {
		saveButton.click();	
		return PageFactory.initElements(driver, PasteViewPage.class);
	}
	
	public PasteViewPage editAll(String name, String paste, String syntax, String exposure) {
		typeNewName(name);
		typeNewPaste(paste);
		selectSyntax(syntax);
		selectExposure(exposure);
		return submitNewPaste();
	}
	
	public PasteViewPage editName(String name) {
		typeNewName(name);
		return submitNewPaste();
	}
	
	public PasteViewPage EditText(String paste) {
		typeNewPaste(paste);
		return submitNewPaste();
	}
	
	public MyArchivePage goToMyArchive() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(myArchiveLink));
		myArchiveLink.click();		
		return PageFactory.initElements(driver, MyArchivePage.class);
	}
	
}
