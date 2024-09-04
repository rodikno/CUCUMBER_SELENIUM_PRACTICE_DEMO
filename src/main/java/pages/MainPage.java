package pages;


import components.ContactUsSection;
import components.RoomBookingComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private static final String PAGE_URI = "https://automationintesting.online/";
    private final RoomBookingComponent roomBookingSection;
    private final ContactUsSection contactUsSection;

    // Locators
    private static final By hotelDescription = By.xpath("//div[@class='row hotel-description']");
    private static final By letMeHackButton = By.xpath("//div[@data-toggle='collapse']/button");

    public MainPage(WebDriver driver) throws InterruptedException {
        super(driver);
        driver.get(PAGE_URI);
        waitForElementToBeVisible(driver.findElement(letMeHackButton)).click();
        this.roomBookingSection = new RoomBookingComponent(driver);
        this.contactUsSection = new ContactUsSection(driver);
    }

    public RoomBookingComponent getRoomBookingSection() {
        return this.roomBookingSection;
    }

    public ContactUsSection getContactUsSection() {
        return this.contactUsSection;
    }


}