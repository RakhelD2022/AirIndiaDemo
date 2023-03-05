package DemoTest.AirIndia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoTest.AirIndia.Resources.HelperClass;

public class SearchResultPage extends HelperClass {
	public WebDriver driver;

    public SearchResultPage(WebDriver rdriver)
    {
        driver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    
    @FindBy(xpath="//*[@class='mat-menu-trigger body-1 menu-trigger']")
    private WebElement dropdownSorting;
    
    @FindBy(xpath="//span[contains(text(), 'Earliest')]")
    private WebElement txtSortByEarliest;
    
    @FindBy(xpath="(//div[@class='flight-card-button-section ng-star-inserted']//button)[2]")
    private WebElement earliestFlightBusiness;
    
    @FindBy(xpath="//div[contains(text(),'SUPER VALUE BUSINESS')]//ancestor::div[1]//preceding::i[1]")
    private WebElement radioBtnWebSpecialBusiness;
    
    @FindBy(xpath="//span[contains(text(),'Continue')]//ancestor::button")
    private WebElement btnContinue;
    
    @FindBy(xpath="//span[contains(text(),'Keep Web Special Business')]")
    private WebElement btnKeepWSB;
    
    public void SelectSortOption() throws InterruptedException {
    	dropdownSorting.click();
    	WaitForFiveSeconds();
    	txtSortByEarliest.click();
    	WaitForFiveSeconds();
    }
    
    public void SelectFlight() throws InterruptedException {
    	earliestFlightBusiness.click();
    	WaitForFiveSeconds();
    	radioBtnWebSpecialBusiness.click();
    	WaitForFiveSeconds();
    	btnContinue.click();
    	WaitForFiveSeconds();
    	//btnKeepWSB.click();
    	WaitForFiveSeconds();
    	System.out.println("Selected the earliest business flight available.");
    }

}