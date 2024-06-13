Feature: Argos Product Purchase

  Scenario: Search for a product and add to basket
    Given I am on the Argos homepage
    When I search for "Kicker Ball"
    Then I should see results for "Kicker Ball"
    When I add the first product to the basket
    Then the product should be in the basket
    When I increase the quantity by 2
    Then the subtotal should be updated accordingly
