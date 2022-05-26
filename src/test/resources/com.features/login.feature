Feature: Login page feature

  Scenario: Login page title
    Given User is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  Scenario: Forgot Password link
    Given User is on login page
    Then forgot password link should be displayed

  Scenario: Login with correct credentials
    Given User is on login page
    When user enters username "harleen.hira@gmail.com"
    And user enters password "Argus123$"
    And user clicks on login button


