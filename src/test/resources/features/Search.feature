Feature: Search functionality


  Scenario: Search for a valid product
    When  I enter valid product iphone in the search field
    And   I click on search button
    Then  Valid product should get displayed in the search results

  Scenario: Search for a invalid product
    When  I enter valid product iphone12 in the search field
    And   I click on search button
    Then  error message should get displayed in the search results
