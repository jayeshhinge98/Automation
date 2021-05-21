Feature: Verify RegresAPI's

Scenario: Verify list of users using list user API
	Given "page" "2" is given as parameter
	When user calls "ListUsers" api using "Get" request
	Then status code should be 200
	And "page" in response body is "2"
	And "support.url" in response body is "https://reqres.in/#support-heading"
	And "data[0].email" in response body is "michael.lawson@reqres.in"
#	And "<key>" in response body is "<value>"  #use Scenario Outline: instead of Scenario:
		
#Examples:
#	|key  | value |
#	|page | 2 |
#	|support.url | https://reqres.in/#support-heading |
	
Scenario Outline: Verify user created successfully
	Given "<name>" and "<job>" send as payload
	When user calls "CreateUser" api using "post" request
	Then status code should be 201
#	And verify "<name>" and "<job>" getting created using "ListUsers"
	And "name" in response body is "<name>"
	And "job" in response body is "<job>"
	
Examples:
	|name  | job |
	|mark henry | Sr QA Engineer |	

Scenario: Verify when user not found then it gives 404
	Given "id" "23" is given as parameter
	When user calls "ListUsers" api using "Get" request
	Then status code should be 404

Scenario: Verify while deleting record which is not present gives 204
	Given "id" "23" is given as parameter
	When user calls "ListUsers" api using "delete" request
	Then status code should be 204
	
Scenario: Verify once registration unsuccessful then gives 400 and error message
	Given "email" as "sydney@fife" send as payload
	When user calls "RegisterUnsuccess" api using "post" request
	Then status code should be 400
	And "error" in response body is "Missing password"
	