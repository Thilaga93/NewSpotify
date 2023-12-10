Feature: Validate if a song can be added to playlist
 


  Scenario Outline: verify support link
    Given Login to spotify
    Then add song to playlist kathadikkuthu
    |Song|
    |<Songs>|
    |<Songs>|
    And display message
    
    Examples:
    |Songs|
    |"Kathadikkuthu"|
    #|"Anna nagar Andalu"|