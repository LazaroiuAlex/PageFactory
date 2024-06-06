package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement userField;

	@FindBy(id="password")
	public WebElement passField;
	
	@FindBy(css = "button[name='login']")
	public WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
	public WebElement myAccountContent;
	
	public void loginInApp(String username, String password) {
		
		sendKeys(userField, username);
		sendKeys(passField, password);
		click(loginBtn);
		
	}
	
	
}
