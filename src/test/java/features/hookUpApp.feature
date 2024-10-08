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

  @Checkboxes
  Scenario: User interacts with checkboxes on the Checkboxes page
    Given User navigates to the Checkboxes page
    When User verifies the initial status of the checkboxes
    Then User selects the first checkbox if not already selected
    And User unselects the second checkbox if already selected

  @ContextMenu
  Scenario: User triggers a JavaScript alert via Context menu
    Given User navigates to the Context Menu page
    When User right-clicks on the box
    Then A JavaScript alert should appear with the message "You selected a context menu"