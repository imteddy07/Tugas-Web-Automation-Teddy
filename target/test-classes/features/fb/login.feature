Feature: FB Login
@fb
  Scenario: User has failed to login FB
    Given Teddy open facebook login page
    When Teddy input email and password
    And Teddy click button login
    Then Teddy can't see my news feed
    But Teddy see FB has disabled my Account