Feature: FB Login
@fb
  Scenario: User has failed to login FB
    Given Teddy open facebook login page
    When I input email and password
    And I click button login
    Then I can't see my news feed
    But I see FB has disabled my Account