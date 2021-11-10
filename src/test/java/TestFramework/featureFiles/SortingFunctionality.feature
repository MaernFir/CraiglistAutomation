Feature: Happy path for Test automation candidate
  User should be able to test sorting functionality

  Scenario: Navigating to test Automation engineer and verifying paragraph
    Given User navigates to website
     When User clicks housing link
     Then User checks "sortingButton" value at dropdown
      |upcoming  |
      |newest    |
      |price ↑   |
      |price ↓   |
     Then User clicks "priceAscending" dropdown functionality
     Then User check sorting
     Then User searches "something" on search bar
     Then User checks "sortingButton" value at dropdown
      |upcoming |
      |newest   |
      |relevant |
      |price ↑  |
      |price ↓ |
