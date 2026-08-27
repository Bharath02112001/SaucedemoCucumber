Feature: Testing the Cart

  Background:
    Given user login with valid credentials
    And user adds Backpack

  Scenario: Verify Add to Cart
    Then cart count should be 1

  Scenario: Verify Checkout
    When user proceeds to checkout
    Then order should be placed successfully
