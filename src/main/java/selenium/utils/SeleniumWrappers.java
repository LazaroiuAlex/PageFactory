package selenium.utils;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest {
	
	public SeleniumWrappers (WebDriver driver) {
		this.driver = driver;		
	}
	
	public void click(WebElement element) {
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		}catch(StaleElementReferenceException e){
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}catch(NoSuchElementException e) {
			System.out.println("Element not found " + element.getAttribute("outerHTML"));
			throw new TestException(e.getMessage());
		}
	}

}
