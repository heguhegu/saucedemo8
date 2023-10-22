Feature: Login Page Aplikasi Saucedemo

  Scenario: Success Login
    Given Halaman login saucedemo
    When Input standar user
    And Input valid password
    And Click login button
    Then User in on dashboard page

  Scenario: Failed Username Login
    Given Halaman login saucedemo
    When Input invalid username
    And Input valid password
    And Click login button
    Then User get error login message

  Scenario: Failed Password Login
    Given Halaman login saucedemo
    When Input standar user
    And Input invalid password
    And Click login button
    Then User get error login message

  Scenario: User Locked
    Given Halaman login saucedemo
    When Input locked out user
    And Input valid password
    And Click login button
    Then User get locked error message