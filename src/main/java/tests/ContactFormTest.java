package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ContactPage;
import pages.MenuPage;
import selenium.utils.BaseTest;
import selenium.utils.TestNgListener;

@Listeners(TestNgListener.class)
public class ContactFormTest extends BaseTest{

	@Test(priority = 1)
	public void sendValidMessage() {
		
		MenuPage menuPage =  new MenuPage(driver);
		menuPage.click(menuPage.contactLink);
		ContactPage contactPage = new ContactPage(driver);
		
		contactPage.sendMessage("Ion", "ion@ion.ion", "Salut ", "Salut eu sunt ion");
		
		assertEquals(contactPage.getText(contactPage.sentMsgText), "Thank you for your message. It has been sent.");
	}
	
	@Test(priority = 2)
	public void sendInvalidMessage() {
		
		MenuPage menuPage =  new MenuPage(driver);
		menuPage.click(menuPage.contactLink);
		ContactPage contactPage = new ContactPage(driver);
		
		contactPage.sendMessage("Ion", "", "Salut ", "Salut eu sunt ion");
		
		assertEquals(contactPage.getText(contactPage.sentMsgText), "One or more fields have an error. Please check and try again.");
	}
	
	
}
