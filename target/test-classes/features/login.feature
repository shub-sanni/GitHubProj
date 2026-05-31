Feature: login feature we need to validate login feature

  @login
  Scenario Outline: Successful login with valid credentials
    Given user is on login page
    When user enter valid credentials user"<user>"
    And user enter valid credentials pass"<pwd>"
    And user clicks on login button
    Then user navigate to homepage
    And user click on logout button
    Then user returns back

    Examples:
      | user     | pwd                  |
      | practice | SuperSecretPassword! |
     #| username | wrong                |
