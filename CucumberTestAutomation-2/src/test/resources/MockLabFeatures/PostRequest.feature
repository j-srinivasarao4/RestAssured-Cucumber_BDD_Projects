@Post
Feature: I am testing POST API request of three different Scenarios
    
    @sree2
    Scenario: POST Sync Connector Containers|Poll & Verify Backup Completion
        Given I Set POST Connector endpoint as "http://dummy.restapiexample.com/"
        When I Send a POST HTTP request with request body & HEADER as "application/json." of endpoint as "api/v1/create"
        Then I receive valid HTTP response code 201
        And Response BODY POST is non-empty.