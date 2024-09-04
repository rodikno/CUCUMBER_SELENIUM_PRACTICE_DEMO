package components;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactUsSection {

    private WebDriver driver;
    WebElement root;

    public ContactUsSection(WebDriver driver) {
        this.driver = driver;
        this.root = driver.findElement(sectionRoot);
    }


    // "Contact Us" form controls
    public static final By sectionRoot = By.cssSelector("div.row.contact");
    public static final By nameField = By.cssSelector("input[data-testid='ContactName']");
    public static final By emailField = By.cssSelector("input[data-testid='ContactEmail']");
    public static final By phoneField = By.cssSelector("input[data-testid='ContactPhone']");
    public static final By subjectField = By.cssSelector("input[data-testid='ContactSubject']");
    public static final By messageField = By.cssSelector("textarea[data-testid='ContactDescription']");
    public static final By formSubmitButton = By.id("submitContact");


    // Success message after the form was submitted
    public static final By successMessageTitle = By.cssSelector("div.row.contact h2");
    public static final By successMessageBody = By.cssSelector("div.row.contact > div.col-sm-5 > div > p");


    public String getSuccessMessageTitleText() {
        return root.findElement(By.cssSelector("h2")).getText();
    }

    public String getSuccessMessageDescription() {
        List<WebElement> bodyParts = driver.findElements(successMessageBody);

        String successBodyCombined = "";

        for (WebElement paragraph : bodyParts) {
            successBodyCombined += paragraph.getText();
        }

        return successBodyCombined;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }


    public void clearFields() {
        driver.findElement(nameField).clear();
        driver.findElement(emailField).clear();
        driver.findElement(phoneField).clear();
        driver.findElement(subjectField).clear();
        driver.findElement(messageField).clear();
    }


    public void waitForSectionToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionRoot));
    }

    public void fillInTheFormWithFakeData() {
        Faker faker = new Faker();

        enterName(faker.name().fullName());
        enterEmail(faker.internet().emailAddress());
        enterPhone(faker.phoneNumber().phoneNumber());
        enterSubject(faker.lorem().sentence());
        enterMessage(faker.lorem().paragraph());
    }

    public void submitForm() {
        driver.findElement(formSubmitButton).click();
    }


}
