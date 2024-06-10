package selenium.utils;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import framework.utils.Log;


public class SeleniumWrappers extends BaseTest{

	
	public SeleniumWrappers (WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void click(WebElement element) {
		Log.info("called <click()> on element: " + element);
		try {
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			Log.info("called <waitForElementToBeClickable> on element: " + element);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			
		}catch(StaleElementReferenceException e) {
			Log.error("StaleElementException on element: " + element);
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			Log.error("called <waitForStalenessOf> element: " + element);
			wait.until(ExpectedConditions.stalenessOf(element));
			Log.info("called <click()> on element: " + element);
			element.click();
		}catch (Exception e) {
			Log.error("Exception occured on " + element.getAttribute("outerHTML"));
			Log.error("Exception occured on " + element);
			Log.error(e.getMessage());
			throw new TestException("unable to <click()> on element: " +element);
			
		}
	}
	
	
	public void sendKeys(WebElement element, String textToWrite) {
		Log.info("Called method <sendKeys> on element " + element);
		try {
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			Log.info("called <waitForVisibilityOfElement()> on element: " + element);
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("called <clear()> on element: " + element);
			element.clear();
			element.sendKeys(textToWrite);
			
		}catch(Exception e) {
			Log.error("Exception occured on <sendKeys()> on element: " + element);
			Log.error(e.getMessage());
			throw new TestException("unable to <sendKeys()> on element: " +element);
		}

		
	}
	
	
}
