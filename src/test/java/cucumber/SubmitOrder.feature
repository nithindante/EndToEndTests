
@tag
Feature: Purchase a item from E-Commerce Website
  Adding a item to cart and purchasing the order 

Background: 
Given I landed on the Ecommerce page


  @Regression
  Scenario Outline: Positive Test case of purchasing a item 
    Given I must be logged in username <username> and password <password>
    When I add product <product> to cart 
    And I verify the <product> add it to checkout
    Then I verify the <text> is displayed or not 

    Examples: 
      | username  									| password 					| product  					| text 											|
      | nithinrajkumar@gmail.com 		|     Sreekuty1@ 		| ADIDAS ORIGINAL		| THANKYOU FOR THE ORDER.		|
      | kannan123@gmail.com 				|     Sreekuty1@ 		| IPHONE 13 PRO			| THANKYOU FOR THE ORDER.		|
