package ee.ut.vl.selenium.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ee.ut.vl.selenium.pageobjects.LoginPage;
import ee.ut.vl.selenium.pageobjects.MyArchivePage;
import ee.ut.vl.selenium.pageobjects.PasteAddPage;
import ee.ut.vl.selenium.pageobjects.PasteEditPage;
import ee.ut.vl.selenium.pageobjects.PasteViewPage;


public class PasteAddAndEditTest {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	@Test
	public void addPaste() {
		LoginPage loginPage = LoginPage.navigateTo(driver);
		PasteAddPage pasteAddPage = loginPage.loginAs("kapa", "parool");
		PasteViewPage pasteViewPage = pasteAddPage.addNewPaste("paste et", "hanemaksa \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti" +
				"hea , jee-jee-jeee!", "C++", "Private");
		assertThat(pasteViewPage.getPasteName(), containsString("paste et"));
		assertThat(pasteViewPage.getPasteText(), containsString("hanemaksa"));
		MyArchivePage myArchivePage = MyArchivePage.navigateTo(driver);
		assertThat(myArchivePage.getNewestPasteSyntax(), containsString("C++"));
		assertThat(myArchivePage.getNewestPasteExposure(), containsString("Private"));
		PasteViewPage pasteViewPage2 = myArchivePage.goViewNewestPaste();
		MyArchivePage myArchivePage2 = pasteViewPage2.deletePaste();
		myArchivePage2.logOut();
	}
	
	@Test
	public void editPaste() {
		LoginPage loginPage = LoginPage.navigateTo(driver);
		PasteAddPage pasteAddPage = loginPage.loginAs("kapa", "parool");
		PasteViewPage pasteViewPage = pasteAddPage.addNewPaste("paste et", "hanemaksa \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti" +
				"hea , jee-jee-jeee!", "C++", "Private");
		PasteEditPage pasteEditPage = pasteViewPage.editPaste();
		PasteViewPage pasteViewPage2 = pasteEditPage.editAll("moos", "õuna-mango \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti \n" +
				"eriti" +
				"hea , jee-jee-jeee!", "Python", "Public");
		assertThat(pasteViewPage2.getPasteName(), containsString("moos"));
		assertThat(pasteViewPage2.getPasteText(), containsString("õuna-mango"));
		assertThat(pasteViewPage2.getPasteText(), not(containsString("hanemaksa")));
		MyArchivePage myArchivePage = MyArchivePage.navigateTo(driver);
		assertThat(myArchivePage.getNewestPasteSyntax(), containsString("Python"));
		assertThat(myArchivePage.getNewestPasteExposure(), containsString("Public"));
		PasteViewPage pasteViewPage3 = myArchivePage.goViewNewestPaste();
		MyArchivePage myArchivePage2 = pasteViewPage3.deletePaste();
		myArchivePage2.logOut();
	}

}
