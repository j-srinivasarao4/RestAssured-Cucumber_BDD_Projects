@api @put
Feature: I am testing API requests of Mock Lab Rest APIs

  @put
  Scenario: Put request to update/modify existing user
    Given Go rest API is up and running
    When I hit the api with get request and end point as "https://ey214.mocklab.io/json/2"
    Then API should update selected user in the params
  
    
    