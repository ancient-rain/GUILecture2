Feature: Baseball
  As an avid Rose-Hulman baseball fan, in order to know how the team is doing, I 
  want to view the team’s schedule.

  Scenario: Baseball team won 5/2
    Given I am using Firefox
    And I load the Athletics page
    When I load the Baseball 2017 schedule
    Then the scheduleshould say that the team won 11-2 on May 2nd
