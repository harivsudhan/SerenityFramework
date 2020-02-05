Feature: Angular BrandStory-Sample feature to test Angular7

  Background: launch the BrandStory application
    Given I navigate to BrandStory Page
    Then I should be able to get the page loaded

  @Navigateprojects
  Scenario Outline: Navigate to the Development website and verify the projects
    Given User Navigates to Development Website
    When User selects the "<Product>" project
    Then User verify the "<Display>" display of the project navigated

    Examples: 
      | Product          | Display                    |
      | ATI Technologies | ATI Technologies Portfolio |
      | Vymo             | Vymo Portfolio             |
