@tag
  Feature: Purchase the order from Ecommerce Website
    I want to use this template for my feature file

    Background:
      Given I landed on ecommerce page
  @tag2
  Scenario Outline: Positive Test of Submit Order
    Given Logged in with username <username> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
    | username | password | productName |
    | shetty@gmail.com | Iamking@000 | ZARA COAT 3 |