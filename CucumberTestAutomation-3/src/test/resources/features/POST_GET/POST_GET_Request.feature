@post-get
Feature: I am testing post-get request for onedrive-oganization-containers-connector APIs
      
      @post1
	    Scenario: POST Connector Create OneDrive
	        Given I Set POST Connector OneDrive endpoint
	        When I Set HEADER param request content type as "application/json."
	        And Set Post connector request Body
	        And Send a POST HTTP request
	        Then I receive valid HTTP response code 201
	        And Response BODY POST is non-empty.
	
	 
	    @post2
	    Scenario: POST Organization Create
	        Given I Set POST organizations endpoint
	        When I Set HEADER param request content type as "application/json."
	        And Set organization request Body
	        And Send a POST HTTP request
	        Then I receive valid HTTP response code 201
	        And Response BODY POST is non-empty.
	
	 
	    @get1
	    Scenario: GET  ContainersSetLastCreatedBackup
	        Given I Set GET posts api endpoint ContainersSetLastCreatedBackup
	        When I Set HEADER param request content type as "application/json."
	        And Send GET HTTP request
	        Then I receive valid HTTP response code 200 for GET.
	        And Response BODY GET is non-empty
	
	 
	    @post3
	    Scenario: POST Sync Connector Containers
	        Given I Set POST Sync Containers endpoint
	        When I Set HEADER param request content type as "application/json."
	        And Set sync connector containers request Body
	        And Send a POST HTTP request
	        Then I receive valid HTTP response code 201
          And Response BODY POST is non-empty.