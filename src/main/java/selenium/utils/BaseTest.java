package selenium.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class BaseTest {
	
	public WebDriver driver;

	
	@Parameters({"url"})
	
	@BeforeClass
	public void setup(String appURL) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(appURL);
	}
	
	//@AfterClass
	public void teardown() throws InterruptedException { //doar for learning purposes
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File poza = sc.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			try {
				Files.copy(poza, new File("poze/"+result.getName()+"-"+timeStamp+".png"));
				System.out.println("Picture saved!");
			}catch(IOException err) {
				System.out.println("Picture could not be saved!");
				err.printStackTrace();
			}
			
			
		}
		
	}

}
