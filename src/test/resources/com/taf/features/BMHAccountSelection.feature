@Sanity
Feature: Account Selection Functionalities 

  Background: User is Logged In 
    Given I launch the "PrivateCookieUrl1" 
     Then I should be logged in to BMRC application 
  
  @AccountDetails 
  Scenario Outline: Select the Account Number in the Account selection screen and Verify the Account Details 
    Given I search for "<Account Number>" in the Account Selection Screen 
    When the accountNumber in the Account Overview table is clicked 
    Then I should verify the "<Account Number>" in the Account Details popUp window 
    Then I expand and verify the below Account Information Blocks in the popUp window
    | General | Information products | Credit | RPK | 
    And I close the Account details popUp window 
  
    Examples: 
      | Account Number     | 
      | NL15RABO0720196558 | 
  
  @AccountModify 
  Scenario Outline: Select and Modify the Account Number and verify the modified Account Details 
   Given I search for "<Account Number>" in the Account Selection Screen 
    When the Account Number in the Account Overview table is selected 
    Then I should verify the "<Account Number>" in the Account settings screen 
    And I modify random data for the below combobox
    | ABB code commercial | ABB code operational | Administrative location code | Affiliated institution code | Frequency of account statements | 
    And I modify the random data for the below radio button
    | Debt block | AW contra account desired | 
    When I click complete button
    And the accountNumber in the Account Overview table is clicked  
    Then I should verify the "<Account Number>" in the Account Details popUp window 
    And I verify modified data for the below combobox
    | ABB code commercial | ABB code operational | Administrative location code | Affiliated institution code | Frequency of account statements | 
    And I verify modified data for the below radio button
    | Debt block | AW contra account desired |
    And I close the Account details popUp window 
  
    Examples: 
      | Account Number     | 
      | NL66RABO0753656469 | 
  
  @AccountCounters
  Scenario Outline: Select the Account Number and verify the Counter/Amounts Screen 
   Given I search for "<Account Number>" in the Account Selection Screen 
    When the Account Number in the Account Overview table is selected
    Then I should verify the "<Account Number>" in the Counter/Amounts screen 
#    And I select random data for "Rate group" and click search
#    Then I should verify the Counter amount result table
#    When I click "clear" button
#    And I select random data for "Transaction code on RA" and click search
#    Then I should verify the Counter amount result table
#    When I click "clear" button
#    And I select random data for "Starting date" and click search
#    Then I should verify the Counter amount result table
#    When I click "clear" button
#    Then I should verify the Counter amount result table 
#    When I click Next button
#    Then I should verify the Counter amount result table
    And I select random data for "Note period" and click search
    Then I should verify the Counter amount result table
    When I click Download CSV button
#    Then I should verify the downloaded CSV file contains the total rows displayed in the result table 
  
    Examples: 
      | Account Number     | 
      | NL15RABO0769157696 | 
  
  @AccountConvert 
  Scenario Outline: Select and Convert the Account Type and verify the Account Number
    Given I search for "<Account Number>" in the Account Selection Screen 
    When the Account Number in the Account Overview table is selected 
    Then I should verify the "<Account Number>" in the Convert screen
    And I select random data for Account Type and click convert
    Then I should verify the Account Type in the Account settings screen
    And I click complete button
    When the accountNumber in the Account Overview table is clicked 
    Then I should verify the Account Type in the Account Details popUp window 
    And I close the Account details popUp window 
  
    Examples: 
      | Account Number     | 
      | NL15RABO0720196558 | 
  
  
