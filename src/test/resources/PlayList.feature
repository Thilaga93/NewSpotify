Feature: Validate if a song can be added to playlist
 


  Scenario: verify support link
    Given Login to spotify
    Then add song to playlist kathadikkuthu
    |Song|
    |"kathadikkuthu"|
    And display message