
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Positive and Negative cases of Login validation
    Given I landed on the Ecommerce page
    When I must be logged in username <username> and password <password>
    Then I verify the <text> is clearly displayed or not 

    Examples: 
      | username  								|password 				| text  											 |
      | nithinrajkumarr@gmail.com |     Sreekuty1@ 	|  Incorrect email or password.|
     
