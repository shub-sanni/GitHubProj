Feature: User Registration
@regester
Scenario: Successful registration with valid credentials
Given user is on registration page
When user enters new username "practiceuser134"
And user enters new password "Password123!"
And user confirms new password "Password123!"
And user clicks on registration button
Then user land on login page
And  user confirms success message "Successfully registered, you can log in now." should be displayed
