
@tag
Feature: Error validation 
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of the scenario outline
    Given I landed on the Ecommerce page 
    When  Login with username "<name>" pasword "<password>" 
    
    Then "Incorrect email or password." message is dispalyed  

    Examples: 
      | name                      |    password      |
      | testing121@gmail.com     |   Naga@1212       | 


