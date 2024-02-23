Feature: Validating TruTime Functionalities

  Scenario: Successful Validation
    Given the user is on the be.cognizant page
    When the user clicks the profile icon at the top corner of the page
    And check the informations displayed or not
    Then his/her name and email is captured

  Scenario: Successful Navigation to Tru Time
    Given In the be.cognizant page validating OneCognizant app is visbile or not
    When clicking the Onecognizant app
    And switching to next window
    And click on the search icon
    Then type Trutime and click search
    And select trutime from the search

  Scenario: Successful validation
    
    Given Navigating to trutime
    And extract dates of week and days 
    And check those dates with system date and validate it
    When checking the date format to see if the current date is highlighted or not
    Then Validate backdated topup date is visible or not
    And Current month and year should match with System calendar
    And Print all legends
