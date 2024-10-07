Feature: Practice automating the cases in hookupapp website

  @AddRemoveButton
  Scenario: Add/Remove elements
    Given User goes to AddRemove Elements page
    When user clicks on the Add Element button
    Then a Delete button appears
    When user clicks on the Delete button
    Then the Delete button should disappear

  @BasicAuth
  Scenario: User successfully logs in
    Given User navigates to the Basic Auth page with valid credentials
    Then User should see a confirmation message