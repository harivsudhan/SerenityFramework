@regression
Feature: Checkout cart
  Description: Checkout shirt and add to the Cart

  Background: User is Logged In
    Given I navigate to the login page
    When I submit username and password
    Then I should be logged in to "My Account"

  @SelectProduct
  Scenario Outline: Search a product and add the product to the Cart
    Given User search for "<Product>" product
    When User selects the "<Shirt>" Shirt "<color>" color and "<size>" size to the cart
    Then User cart should display with added item "<Shirt>"

    Examples: 
      | Product | Shirt                      | size | color |
      | Shirt   | blue denim super oversized |   32 | blue  |
