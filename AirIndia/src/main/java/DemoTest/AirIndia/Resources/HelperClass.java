package DemoTest.AirIndia.Resources;

import org.apache.logging.log4j.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import dev.failsafe.internal.util.Assert;

public class HelperClass {
	public static void WaitForFiveSeconds() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public static void WaitForTenSeconds() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public static void ValidateTitleOfPage(String expectedTitle, String actualTitle) {
		boolean titleMatch = false;
		if(expectedTitle.equals(actualTitle))
		{
			titleMatch = true;
		}
		Assert.isTrue(titleMatch, "Title is not matching");
	}
	
	public static void EnterTextAndEnter(WebElement element, String text) throws InterruptedException {
		element.sendKeys(text);
		WaitForFiveSeconds();
		element.sendKeys(Keys.ENTER);
		WaitForFiveSeconds();
	}
	
	public static void LogInfo(String msg) {
		Logger log = LogManager.getLogger("HelperClass");
		log.info(msg);
	}
}
