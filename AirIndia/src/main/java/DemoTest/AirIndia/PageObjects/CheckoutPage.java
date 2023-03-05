package DemoTest.AirIndia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoTest.AirIndia.Resources.HelperClass;

public class CheckoutPage extends HelperClass {

	public WebDriver driver;

    public CheckoutPage(WebDriver rdriver)
    {
        driver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    
    @FindBy(xpath="//button/span/span[contains(text(),'Checkout')]")
    private WebElement btnCheckout;
    
    @FindBy(xpath="//*[contains(text(), 'Card Issued in India')]")
    private WebElement lnkCardInIndia;
    
    @FindBy(xpath="//input[@id='mat-radio-2-input']")
    private WebElement radBtnPaymentCards;
    
    @FindBy(xpath="//*[@class='mat-checkbox-inner-container']")
    private WebElement chkBxPaymentCards;
    
    @FindBy(xpath="//*[contains(text(),'Pay INR')]//ancestor::button")
    private WebElement btnPay;    
    
    @FindBy(id="proceedForm")
    private WebElement btnSubmitPayment;
    
    @FindBy(id="goBack")
    private WebElement lnkCancelTransaction;
    
    @FindBy(xpath="//*[@id=\"CancelTab\"]/div[1]/div/div[1]/label/input")
    private WebElement chkBxCause;
    
    @FindBy(id="fdbCancel")
    private WebElement btnAbort;  
    
    @FindBy(xpath="//*[contains(text(),'Your Flight')]")
    private WebElement txtInCheckoutPg;
  
  
    
    public void ClickCkeckoutAndCancelPayment() throws InterruptedException {
    	WaitForTenSeconds();
    	WaitForTenSeconds();
    	btnCheckout.click();
    	LogInfo("Entered checkout page and moved into payment page...");
    	WaitForFiveSeconds();
    	WaitForTenSeconds();
    	driver.close();
    	/*lnkCardInIndia.click();
    	WaitForFiveSeconds();
    	radBtnPaymentCards.click();
    	chkBxPaymentCards.click();
    	btnPay.click();
    	WaitForFiveSeconds();
    	WaitForFiveSeconds();
    	WaitForFiveSeconds();
    	lnkCancelTransaction.click();
    	WaitForFiveSeconds();
    	WaitForFiveSeconds();
    	chkBxCause.click();
    	btnAbort.click();
    	WaitForFiveSeconds();
    	WaitForFiveSeconds();
    	WaitForFiveSeconds();*/
    }
}
