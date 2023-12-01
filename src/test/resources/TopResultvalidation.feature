Feature: Validate the top results
 


  Scenario: verify the top results
    Given Login to spotify
    Then  search for song "Hukum"
    And get the search result and save it in "@TopResult"
    And search for the song with keyword "@TopResult" and validate the result
    