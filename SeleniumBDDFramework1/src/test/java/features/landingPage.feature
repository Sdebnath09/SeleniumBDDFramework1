#Author: Snehasish Debnath
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login functionality
  
  @tag1
  Scenario: User logs in with valid credentials
    Given User is on the login page
    When User enters "admin" and "password123"
    Then User should be redirected to the homepage

  #@tag2
#  Scenario Outline: User logs in with valid credentials
 #   Given <name> is on the login page
 #   When I check for the <value> in step
  #  Then I verify the <status> in step

  #  Examples: 
  #    | name  | Username  | Password    |
   #   | User1 |   admin 	| password123 |
  #    | User2 |   admin2	| password321 |
