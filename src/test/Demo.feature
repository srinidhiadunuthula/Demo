Feature:Test the Petstore swagger functionality
Scenario: Add a pet and verify image is uploaded
  Given I Set POST employee service api endpoint
  And I add a pet to petstore
  And The pet is added
  Then verify that image is uploaded
  Then I search for new pets
  And The pet is added

  Scenario: Validate the user can expand and collapse end points
    Then I expand and collapse the pet arrows for endpoints









