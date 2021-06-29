@Get-6S
Feature: I am testing GET requests for getting organization/providers/connectors/containers/containerItems & Backups records

       @get1		
		   Scenario: GET organization record
		        Given I Set GET organization service api endpoint
		        When I Set request HEADER content type as "application/json"
		        And Send a GET HTTP request
		        Then I receive valid HTTP response code 200 while fetching Organizasion
		       
		   @get2
		    Scenario: GET providers record
		        Given I Set GET providers service api endpoint
		        When I Set request HEADER content type as "application/json" to get providers
		        And Send a GET HTTP request to get providers
		        Then I receive valid HTTP response code 200 while fetching providers
		       
		   @get3
		    Scenario: GET connectors record
		        Given I Set GET connectors service api endpoint
		        When I Set request HEADER content type as "application/json" to get connectors
		        And Send a GET HTTP request to get connectors
		        Then I receive valid HTTP response code 200 while fetching connectors
		       
		   @get4
		    Scenario: GET containers record
		        Given I Set GET containers service api endpoint
		        When I Set request HEADER content type as "application/json" to get containers
		        And Send a GET HTTP request to get containers
		        Then I receive valid HTTP response code 200 while fetching containers
		       
		    @get5  
		    Scenario: GET containerItems record
		        Given I Set GET containerItems service api endpoint
		        When I Set request HEADER content type as "application/json" to get containerItems
		        And Send a GET HTTP request to get containerItems
		        Then I receive valid HTTP response code 200 while fetching containerItems
		       
		   @get6
		    Scenario: GET containerItemBackups record
		        Given I Set GET containerItemBackups service api endpoint
		        When I Set request HEADER content type as "application/json" to get containerItemBackups
		        And Send a GET HTTP request to get containerItemBackups
		        Then I receive valid HTTP response code 200 while fetching containerItemBackups