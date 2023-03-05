package DemoTest.AirIndia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoTest.AirIndia.Resources.HelperClass;

public class FlightDetailsPage extends HelperClass {
	public WebDriver driver;

    public FlightDetailsPage(WebDriver rdriver)
    {
        driver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    
    @FindBy(xpath="//div[@class='bound-information responsive']//div[1]")
    private WebElement txtFromToDetails;
    
    @FindBy(xpath="//span[contains(text(),'Fill passenger details')]//ancestor::button")
    private WebElement btnFillPassengerDetails;
    
    public void NavigateToFillPassengerDetails() throws InterruptedException {
    	WaitForFiveSeconds();
    	WaitForFiveSeconds();
    	btnFillPassengerDetails.click();
    	System.out.println("Going to fill passenger name and contact details.");
    	WaitForFiveSeconds();
    }
}
