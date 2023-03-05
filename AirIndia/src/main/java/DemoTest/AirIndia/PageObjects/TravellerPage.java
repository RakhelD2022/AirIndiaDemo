package DemoTest.AirIndia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoTest.AirIndia.Resources.HelperClass;

public class TravellerPage extends HelperClass {
	public WebDriver driver;

    public TravellerPage(WebDriver rdriver)
    {
        driver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    
    @FindBy(xpath="//div[@id='mat-select-value-5']")
    private WebElement dropdownTitle;
    
    @FindBy(xpath="(//span[contains(text(),'Mr')])[1]")
    private WebElement titleMr;
    
    @FindBy(xpath="(//span[contains(text(),'Mrs')])[1]")
    private WebElement titleMrs;
    
    @FindBy(xpath="//input[@formcontrolname='firstName']")
    private WebElement txtFirstName;
    
    @FindBy(xpath="//input[@formcontrolname='lastName']")
    private WebElement txtLastName;
    
    @FindBy(xpath="//input[@formcontrolname='dob']")
    private WebElement txtDOB;
    
    @FindBy(xpath="(//input[@type='email'])[1]")
    private WebElement txteMail;
    
    @FindBy(xpath="(//input[@type='email'])[2]")
    private WebElement txtConfirmeMail;
    
    @FindBy(xpath="//div[@id='mat-select-value-3']")
    private WebElement dropdownMobNoType;
    
    @FindBy(xpath="//input[@aria-describedby='countryCodes']")
    private WebElement txtCountryCode;
    
    @FindBy(xpath="//input[@type='tel']")
    private WebElement txtMobileNbr;
    
    @FindBy(xpath="//span[@class='mat-checkbox-inner-container']")
    private WebElement chkbxPrivacy;
    
    @FindBy(xpath="//*[contains(text(),'Confirm')]//ancestor::button")
    private WebElement btnConfirm;
    
  
    
    public void EnterTravellerDetails(String title, String firstName, String lastName, String dob) throws InterruptedException {
    	WaitForFiveSeconds();
    	WaitForFiveSeconds();
    	dropdownTitle.click();
    	WaitForFiveSeconds();
    	if(title.equals("Mrs")) {
    		titleMrs.click();
    	}
    	else
    	{
    		titleMr.click();
    	}
    	txtFirstName.sendKeys(firstName);
    	txtLastName.sendKeys(lastName);
    	txtDOB.sendKeys(dob);
    	WaitForFiveSeconds();
    	System.out.println(String.format("Entered passenger details.\n Name: " + firstName + " " + lastName));
    }
    
    public void EnterContactDetails(String email, String countryCode, String mobile) throws InterruptedException {
    	txteMail.sendKeys(email);
    	txtConfirmeMail.sendKeys(email);
    	WaitForFiveSeconds();
    	//dropdownMobNoType.click();
    	txtCountryCode.sendKeys(countryCode);
    	txtMobileNbr.sendKeys(mobile);
    	chkbxPrivacy.click();
    	btnConfirm.click();
    	System.out.println(String.format("Entered contact details of the passenger.\n Email Id: " + email + "\n Phone: " + countryCode + mobile));
    }
  
    
}