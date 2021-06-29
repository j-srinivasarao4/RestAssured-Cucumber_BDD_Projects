@Delete
Feature: I am testing DELETE Request by deleting Organization
  
  @sree3
  Scenario: DELETE Organization
      Given I Set DELETE posts api endpoint for DELETE Organization
      When I Send DELETE request
      Then I receive valid HTTP response code 200 for DELETE. to delete Organizasion
 
    
  
    
    