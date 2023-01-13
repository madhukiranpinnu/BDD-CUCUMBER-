Feature: User login
  Registered user should be able to login to application
#Below statement to understand Background keyword
  Background:
    Given I open the application URL to  login page

  Scenario: Login with valid Credentials
    When User enters valid email address madhuoiran91118@gmail.com
    And  User enters valid password madhu!1223
    And  User clicks on login button
    Then User should be login Successfully


  Scenario: Login with invalid Credentials
    When User enters valid email address madhukiran918@gmail.com
    And  User enters valid password 1234
    And  User clicks on login button
    Then User should seeing invalid message

  Scenario: Login with invalid email Credentials
    When User enters valid email address madhukiran918@gmail.com
    And  User enters valid password madhu!1223
    And  User clicks on login button
    Then User should seeing invalid message

  Scenario: Login with invalid password Credentials
    When User enters valid email address madhukiran91118@gmail.com
    And  User enters valid password 1234
    And  User clicks on login button
    Then User should seeing invalid message


  Scenario Outline:
    When User enters valid email address <email>
    And  User enters valid password <password>
    And  User clicks on login button
    Then User should seeing invalid message
    Examples:
      |email       |password|
      |madhu@fg.com|123     |
      |madhu@fg.com|123     |
      |madhu@fg.com|123     |

