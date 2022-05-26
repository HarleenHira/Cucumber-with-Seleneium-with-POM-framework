Feature: Account page feature

  Background:
    Given User has already logged in to application
      | username               | password  |
      | harleen.hira@gmail.com | Argus123$ |

  Scenario: Account page title
    Given user is on accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Account section count
    Given user is on accounts page
    Then user gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And Account section count should be 5



