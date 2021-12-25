Narrative:
The test case check the results on the google search page and then navigate to the OLX page and check if the number of the cars
declared there is greather than 0.

Scenario: Check google results and olx details
Given consumer navigates to google search page
And consumer searches for 'Cars in India' phase
When any results exist on the result page
Then the olx results exist on the search google results page and OLX pages contain valid results counter
