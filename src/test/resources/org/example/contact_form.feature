@functional
Feature: Site contact form

  Background:
    Given the browser is open
    And the main page is open

  @smoke @regression
  Scenario: Fill in the contact form with valid dats and submit
    Given I enter the following data in the Contact Us form
    And I submit the Contact Us form
    Then the confirmation message title is displayed
    And the confirmation message body is displayed
    But the form is not displayed