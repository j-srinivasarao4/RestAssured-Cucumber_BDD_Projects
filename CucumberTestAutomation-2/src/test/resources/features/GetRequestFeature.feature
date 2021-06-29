@api @get
Feature: I am testing get request for Go Rest API
	@sanity
  Scenario: Get request to fetch all users
    Given Go rest API is up and running
    When I hit the api with get request and end point as "http://localhost:3000/Users"
    Then API should return all the users