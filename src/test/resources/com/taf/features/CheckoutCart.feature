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
      
  #Scenario Outline: Navigate to the cart and checkout the product
    #Given User navigate to the cart
    #When User proceeds to checkout
    #Then User Cart should display the Product details of "<Shirt>" with "<color>" and "<size>" with "<price>"
#
    #Examples: 
      #| Shirt       | size | color | price  |
      #| blue denim  |   32 | blue  | ₹43.00 |
      #| brown satin |   32 | brown | ₹30.00 |
