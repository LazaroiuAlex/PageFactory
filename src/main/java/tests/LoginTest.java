package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.MenuPage;
import pages.MyAccountPage;
import selenium.utils.BaseTest;
import selenium.utils.TestNgListener;
import framework.utils.PropertiesFileProcessor;

@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest{


	String user = PropertiesFileProcessor.readPropertiesFile("user", "login.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("pass", "login.properties");

	
	@Test(priority =1)
	public void validLoginTest() {
		
		MenuPage menuPage =  new MenuPage(driver);
		menuPage.click(menuPage.myAccountLink);
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.loginInApp(user, pass);

		assertTrue(myAccountPage.myAccountContent.isDisplayed());
		myAccountPage.click(myAccountPage.logoutBtn);
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		MenuPage menuPage =  new MenuPage(driver);
		menuPage.click(menuPage.myAccountLink);
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.loginInApp(user, "parolaGresita");
		
		assertTrue(myAccountPage.myAccountContent.isDisplayed());
	}
	
}
