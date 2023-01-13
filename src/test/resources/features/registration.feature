
Feature: Registration Feature

  Background:
    Given User is on Registration page

  Scenario: Registration with all Mandatory fields
    When  User enters following all mandatory fields in registration page
      |firstname  | madhu4                   |
      |lastname   | pinnu4                   |
      |email      | madhuoiran91118@gmail.com|
      |phoneno    | 7013908149               |
      |password   | madhu!1223               |
      |confirmPass| madhu!1223               |
    And   User accepts terms
    And   User clicks on continue button in registration page
    Then  User account is successfully created

  Scenario: Register with all Fields
    When  User enters following all mandatory fields in registration page
      |firstname  | madhu                   |
      |lastname   | pinnu                   |
      |email      | madhukiran9118@gmail.com|
      |phoneno    | 7013918149              |
      |password   | madhu@123               |
      |confirmPass| madhu@123               |
    And   User selects yes radio button in registration page
    And   User accepts terms
    And   User clicks on continue button in registration page
    Then  User account is successfully created


  Scenario: Register with Duplicate details
    When  User enters following all mandatory fields in registration page
      |firstname  | madhu4                   |
      |lastname   | pinnu4                   |
      |email      | madhuoiran91118@gmail.com|
      |phoneno    | 7013908149               |
      |password   | madhu!1223               |
      |confirmPass| madhu!1223               |
    And   User selects yes radio button in registration page
    And   User accepts terms
    And   User clicks on continue button in registration page
    Then  User should be seeing invalid message
