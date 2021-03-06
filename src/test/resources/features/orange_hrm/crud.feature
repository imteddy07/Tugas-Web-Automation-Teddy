@all
Feature: Orange HRM - CRUD Employee Data

  Background:
    Given I open Orange HRM login page
    When I input username and password
    And I click login button
    And I access employee list

  @hrmcreate
  Scenario: user add Orange HRM employee successfully
    When I add new employee with required field only
    Then I can see my Personal Details

  @hrmread
  Scenario: User read Orange HRM employee list successfully
    Then I can see new employee list result

  @hrmupdate
  Scenario: User update Orange HRM employee successfully
    When I search for new employee
    And I update new employee's middle name
    Then I can see the Personal Details has changed
  @hrmdelete
  Scenario: User delete Orange HRM employee successfully
    When I search for new employee
    And I delete new emplyee
    Then I can deleted new employee