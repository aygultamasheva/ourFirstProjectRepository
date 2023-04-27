Feature: Admin Login Scenarios: Positive
  As an admin user I want to successfully be able to login and logout from the admin panel



  Scenario: Can successfully login as an admin using valid credentials
    Given the user is on the admin login page
    When the user logs in using the username "admin" and password"parola123!"
    And the user clicks on the login button
    Then the user should successfully log in into the admin panel
    And the user logs out via logout button

#    Scenario: Can successfully login as an admin using username with one character
