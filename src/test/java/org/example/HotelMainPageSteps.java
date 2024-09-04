package org.example;

import helpers.WebDriverProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.MainPage;

public class HotelMainPageSteps {


    MainPage mainPage;
    WebDriver driver;

    public HotelMainPageSteps() throws InterruptedException {
    }

    @Given("the browser is open")
    public void theBrowserIsOpen() throws InterruptedException {
        driver = WebDriverProvider.getDriver();
    }

    @Given("the main page is open")
    public void theMainPageIsOpen() throws InterruptedException {
        mainPage = new MainPage(driver);
    }


    @Given("I enter the following data in the Contact Us form")
    public void iEnterTheFollowingDataInTheContactUsForm() {
        mainPage.getContactUsSection().fillInTheFormWithFakeData();
    }

    @And("I submit the Contact Us form")
    public void iSubmitTheContactUsForm() {
        mainPage.getContactUsSection().submitForm();
    }

    @Then("the confirmation message title is displayed")
    public void theConfirmationMessageTitleIsDisplayed() {
        String actualTitle = mainPage.getContactUsSection().getSuccessMessageTitleText();
        Assert.assertTrue(actualTitle.contains("Thanks for getting in touch"));
    }
}
