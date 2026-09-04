Feature: Login Functionality

  Scenario Outline: Login with valid credentials
    Given user navigates to login page
    And user enters valid email address "<Username>" into email field
    And user enters valid password "<Password>" into password field
    When user click the login button
    Then user should get the result

    Examples:
      | Username                | Password     | Result  |
      | standard_user           | secret_sauce | Valid   |
      #| locked_out_user         | secret_sauce | Invalid |
      | problem_user            | secret_sauce | Valid   |
      | performance_glitch_user | secret_sauce | Valid   |
      | error_user              | secret_sauce | Valid   |
      | visual_user             | secret_sauce | Valid   |
