@Regression
Feature: File upload on Box site

  In order to upload the file on the Box site
  As a user
  I want to successfully login to the site, then create a folder and upload a file to the folder

  Scenario: Validate that an user with valid credentials can create new folder on the Box site

    Given User navigates to the Box website
    When  User enters valid username "qatestingsyd@gmail.com" and password "qatesting123"
    Then  User logs in successfully to the site
    And   User is able to create a new folder

  Scenario: Validate that an user with invalid credentials cannot login to the Box site

    Given User navigates to the Box website
    When  User enters valid username "testing@gmail.com" and password "Testing123"
    Then  User logs is unable to login to the site

  Scenario: Validate that an user with valid credentials can upload a file to a folder on the Box site
    Given User navigates to the Box website
    When  User enters valid username "qatestingsyd@gmail.com" and password "qatesting123"
    Then  User is able to upload a file in the folder