@post
Feature: I am testing post request for cloud Backup API
      
      @tag1
      Scenario: PATCH Backup Last Created Set Last Backup Policy
        Given I Set PATCH Backup Policy endpoint
        When I Set HEADER param request content type as "application/json."
        And Set Patch Backup request Body
        And Send a POST HTTP request
        Then I receive valid HTTP response code 201
        And Response BODY POST is non-empty.

      @tag2
      Scenario: POST Provider Create
        Given I Set POST Provider endpoint
        When I Set HEADER param request content type as "application/json."
        And Set provider request Body
        And Send a POST HTTP request
        Then I receive valid HTTP response code 201
        And Response BODY POST is non-empty.

      @tag3
      Scenario: POST Connector Create Site
        Given I Set POST Connector endpoint
        When I Set HEADER param request content type as "application/json."
        And Set Connector request Body
        And Send a POST HTTP request
        Then I receive valid HTTP response code 201
        And Response BODY POST is non-empty.