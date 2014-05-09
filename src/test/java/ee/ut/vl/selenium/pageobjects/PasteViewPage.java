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


public class PasteViewPage {
	
	private WebDriver driver;
	
	@FindBy(id = "nameOfPaste")
	private WebElement pasteName;
	
	@FindBy(id = "view")
	private WebElement pasteText;
	
	@FindBy(id = "deletePaste")
	private WebElement deleteButton;
	
	@FindBy(id = "editPaste")
	private WebElement editButton;
	
	@FindBy(id = "myarchive")
	private WebElement myArchiveLink;
	
	@FindBy(id = "otherpastes")
	private WebElement otherPastesLink;
	
	
	public PasteViewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getPasteName() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteName));
		return pasteName.getText();
	}
	
	public String getPasteText() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(pasteText));
		return pasteText.getText();
	}
	
	public MyArchivePage deletePaste() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(deleteButton));
		deleteButton.click();	
		return PageFactory.initElements(driver, MyArchivePage.class);
	}
	
	public PasteEditPage editPaste() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(editButton));
		editButton.click();	
		return PageFactory.initElements(driver, PasteEditPage.class);
	}

}
