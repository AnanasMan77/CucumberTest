Feature: Registration of user

  Scenario: Create a user
    Given User is on the create a supporter account page
    When User fills in all the necessary information
    And User clicks on the confirm and join button
    Then An account is created

    Scenario: Create a user without last name
      Given User is on the create a supporter account page
      When User fills in all the necessary information but not the last name
      And User clicks on the confirm and join button
      Then User should recive an error that last name is missing

      Scenario: Create a user with non matching passwords
        Given User is on the create a supporter account page
        When User fills in all the necessary information but the passwords dont match
        And User clicks on the confirm and join button
        Then User should recive an error that the passwords are not matching

        Scenario: Create a user without accepting the terms and conditions
          Given User is on the create a supporter account page
          When User fills in all the necessary information
          But User does not accept terms and conditions
          And User clicks on the confirm and join button
          Then User should recive an error that the terms and conditions must be accepted