Feature: Verify RegresAPI's

Scenario: Verify list of users using list user API
	When user calls "ListUsers" api using "Get" request
	Then status code should be 200
	And "page" in response body is "2"
#	And "support.url" in response body is "https://reqres.in/#support-heading"
#	And "data[0].email" in response body is "https://reqres.in/#support-heading"
#	And "<key>" in response body is "<value>"  #use Scenario Outline: instead of Scenario:
	
#Examples:
#	|key  | value |
#	|page | 2 |
#	|support.url | https://reqres.in/#support-heading |
	
	