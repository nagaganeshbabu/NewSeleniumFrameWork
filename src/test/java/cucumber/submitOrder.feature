
@tag
Feature: Purchase the order from E-commerce Website
 
  
  Background:
    Given  I landed on the Ecommerce page 


  @Regression
  Scenario Outline: Positive Test of submitting the order 
    Given Login with username "<name>" pasword "<password>" 
    When I add product "<productname>" to card
    And checkout "<productname>" and submit the order 
    Then "Thankyou for the order." message is dispalyed on the conformation page 

    Examples: 
      | name                      |    password      | productname         |
      | testing1212@gmail.com     |   Naga@1212      | ZARA COAT 3         |
      | testing121212@gmail.com   |   Naga@1212      | ADIDAS ORIGINAL     |

