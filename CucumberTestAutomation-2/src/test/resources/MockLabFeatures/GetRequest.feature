@Get
Feature: I am testing API requests of Mock Lab Rest APIs
  
  @sree1
  Scenario: GET  ContainersSetLastCreatedBackup
    Given Send GET HTTP request
    When I hit the api with get request and end point as "api/v1/employees"
    Then  I receive valid HTTP response code 200 for GET
    And Response BODY of GET request is non-empty

 
    
    