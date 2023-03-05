package DemoTest.AirIndia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import DemoTest.AirIndia.PageObjects.CheckoutPage;
import DemoTest.AirIndia.PageObjects.FlightDetailsPage;
import DemoTest.AirIndia.PageObjects.SearchPage;
import DemoTest.AirIndia.PageObjects.SearchResultPage;
import DemoTest.AirIndia.PageObjects.TravellerPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookAFlightTest {
	private static WebDriver driver;
	private static String fromPlace;
    private static String toPlace;
    private static int adultCount;
    private static int childCount;
    private static int infantCount;
    private static String travelClass;
    private static String title;
    private static String firstName;
    private static String lastName;
    private static String dob;
    private static String email;
    private static String countryCode;
    private static String mobileNbr;

	@Test
	public void BookAFlight() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\drivers\\browserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to app url
		driver.get("http://ai-content.azurewebsites.net/ai-portal/#/");
		
		//Enter travel details
        fromPlace = "Bhubaneswar";
        toPlace = "Delhi";
        adultCount = 1;
        childCount = 0;
        infantCount = 0;
        travelClass = "Business";
        EnterTravelDetails(fromPlace, toPlace, adultCount, childCount, infantCount, travelClass);
        
      //Select Flight Business
        SelectFlight();
        
        //FillPassengerDetails
        title = "Mr.";
        firstName = "Test";
        lastName = "User";
        dob = "10/01/1988";
        email = "testuser@email.com";
        countryCode = "+91";
        mobileNbr = "9876504321";
        FillPassengerDetails(title, firstName, lastName, dob, email, countryCode, mobileNbr);
        
        CheckOutAndCancelTransaction();
	}
	
	public static void EnterTravelDetails(String fromPlace, String toPlace, int adultCount, int childCount, int infantCount, String travelClass) throws InterruptedException {
		SearchPage searchPageObj = new SearchPage(driver);
		//Close Promo Ad
        searchPageObj.ClosePromoAd();
        
        searchPageObj.EnterToAndFromDestinations(fromPlace, toPlace);
        searchPageObj.SelectDepartDate();
        searchPageObj.EnterPassengers(adultCount, childCount, infantCount);
        searchPageObj.SelectClass(travelClass);
        searchPageObj.ClickSearch();
	}
	
	public static void SelectFlight() throws InterruptedException {
		SearchResultPage SearchResultPageObj = new SearchResultPage(driver);
		SearchResultPageObj.SelectSortOption();
		SearchResultPageObj.SelectFlight();
	}
	
	public static void FillPassengerDetails(String title, String firstName, String lastName, String dob, String email, String countryCode, String mobileNbr) throws InterruptedException {
		FlightDetailsPage FlightDetailsPageObj = new FlightDetailsPage(driver);
		FlightDetailsPageObj.NavigateToFillPassengerDetails();
		
		//Enter details of primary adult passenger
		TravellerPage TravellerPageObj = new TravellerPage(driver);
		TravellerPageObj.EnterTravellerDetails(title, firstName, lastName, dob);
		TravellerPageObj.EnterContactDetails(email, countryCode, mobileNbr);
	}
	
	public static void CheckOutAndCancelTransaction() throws InterruptedException {
		CheckoutPage CheckoutPageObj = new CheckoutPage(driver);
		CheckoutPageObj.ClickCkeckoutAndCancelPayment();
	}
}
