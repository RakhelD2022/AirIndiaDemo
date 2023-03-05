package DemoTest.AirIndia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoTest.AirIndia.Resources.HelperClass;

public class SearchPage extends HelperClass {
	public WebDriver driver;

    public SearchPage(WebDriver rdriver)
    {
        driver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    
    @FindBy(xpath="//*[contains(text(),'X Close')]")
    private WebElement promoCloseLink;
    
    @FindBy(xpath="(//*[@id=\"typeahead-basic\"])[1]")
    private WebElement txtFromFlight;
    
    @FindBy(xpath="(//*[@id=\"typeahead-basic\"])[2]")
    private WebElement txtToFlight;
    
    @FindBy(xpath="//*[@class=\"btn bi bi-calendar3\"]")
    private WebElement lnkDepartDate;
    
    @FindBy(xpath="//*[@id=\"faq_tab_1\"]/div/app-search-flight/div/form/div[1]/app-datepicker-range-popup/div/div[1]/div[1]/div/ngb-datepicker/div[2]/div[2]/ngb-datepicker-month/div[3]/div[5]/span")
    private WebElement txtDateSelected;
    
    @FindBy(xpath="//*[@class='dropdown-toggle passengers-text']")
    private WebElement lnkPassengerCount;
    
    @FindBy(xpath="(//button[@class='col-2' and contains(text(), '+')])[1]")
    private WebElement buttonAddAdultCount;
    
    @FindBy(xpath="(//button[@class='col-2' and contains(text(), '+')])[2]")
    private WebElement buttonAddChildCount;
    
    @FindBy(xpath="(//button[@class='col-2' and contains(text(), '+')])[3]")
    private WebElement buttonAddInfantCount;
    
    @FindBy(xpath="//*[@class='col-12 col-lg-2 py-1 clas']")
    private WebElement dropdownClass; 
    
    @FindBy(xpath="(//span[contains(text(), 'Economy')])[2]")
    private WebElement txtEconomyClass;
    
    @FindBy(xpath="(//span[contains(text(), 'Business')])[1]")
    private WebElement txtBusinessClass;
    
    @FindBy(xpath="(//span[contains(text(), 'First')])[1]")
    private WebElement txtFirstClass;
    
    @FindBy(xpath="//button[contains(text(), 'Show Flights')]")
    private WebElement btnSearch;  
    
    
    public void ClosePromoAd() throws InterruptedException {
    	WaitForFiveSeconds();
    	if (promoCloseLink.isDisplayed())
    	{
    		promoCloseLink.click();
    		System.out.println("Closed the promo banner.");
        	WaitForFiveSeconds();
    	}
    	else
    	{
    		WaitForFiveSeconds();
    	}
    }
    
    public void EnterToAndFromDestinations(String fromPlace, String toPlace) throws InterruptedException {
    	EnterTextAndEnter(txtFromFlight, fromPlace);
    	System.out.println("Entered from place : " + fromPlace);
    	EnterTextAndEnter(txtToFlight, toPlace);
    	System.out.println("Entered from place : " + toPlace);
    }
    
    public void SelectDepartDate() throws InterruptedException {
    	lnkDepartDate.click();
    	WaitForFiveSeconds();
    	txtDateSelected.click();
    	WaitForFiveSeconds();
    	lnkDepartDate.click();
    	System.out.println("Entered departure date.");
    }
    
    public void EnterPassengers(int adultCount, int childCount, int infantCount) throws InterruptedException
    {
    	lnkPassengerCount.click();
    	System.out.println(String.format("No. of passengers: " + adultCount + childCount + infantCount));
    	WaitForFiveSeconds();
    	while(adultCount-1 > 0) {
    		buttonAddAdultCount.click();
    		adultCount--;
    	}
    	
    	while(childCount > 0) {
    		buttonAddChildCount.click();
    		childCount--;
    	}
    	
    	while(infantCount > 0) {
    		buttonAddInfantCount.click();
    		infantCount--;
    	}
    	WaitForFiveSeconds();
    	lnkPassengerCount.click();
    }
    
    public void SelectClass(String travelClass) throws InterruptedException {
    	dropdownClass.click();
    	WaitForFiveSeconds();
    	if (travelClass.equals("Economy")) {
    		txtEconomyClass.click();
    		System.out.println("Travel class : " + travelClass);
    		WaitForFiveSeconds();
    	}
    	if (travelClass.equals("Business")) {
    		txtBusinessClass.click();
    		System.out.println("Travel class : " + travelClass);
    		WaitForFiveSeconds();
    	}
    	if (travelClass.equals("First")) {
    		txtFirstClass.click();
    		System.out.println("Travel class : " + travelClass);
    		WaitForFiveSeconds();
    	}
    }
    
    public void ClickSearch() throws InterruptedException {
    	btnSearch.click();
    	System.out.println("Searching for available flight details...");
    	WaitForFiveSeconds();
    }
}
