package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.MenuPage;
import pages.MyAccountPage;
import selenium.utils.BaseTest;
import framework.utils.PropertiesFileProcessor;

public class LoginTest extends BaseTest {
	
	String user = PropertiesFileProcessor.readPropertiesFile("user", "login.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("pass", "login.properties");
	
	@Test(priority=1)
	public void validLoginTest() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.click(menuPage.myAccountLink);
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.loginInApp(user, pass);
		
		assertTrue(myAccountPage.myAccountContent.isDisplayed());
	}

}
