package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ContactPage;
import pages.MenuPage;
import selenium.utils.BaseTest;
import selenium.utils.TestNgListener;

@Listeners(TestNgListener.class)
public class ContactFormTest extends BaseTest{

	@Test
	public void sendValidMessage() {
		
		MenuPage menuPage =  new MenuPage(driver);
		menuPage.click(menuPage.contactLink);
		ContactPage contactPage = new ContactPage(driver);
		
		contactPage.sendMessage("Ion", "ion@ion.ion", "Salut ", "Salut eu sunt ion");
		
	}
	
	
	
}
