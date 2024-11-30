

Feature: Validating Place API's


@AddPlace  @Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI

Given Add Place payload  "<name>" "<language>" "<address>"

When user calls "AddPlaceAPI" with "post" http request

Then the API call got success with status code 200

And "status" in response body is "OK"

And "scope" in response body is "APP"

And verify place_Id created maps to "<name>" using "getPlaceAPI"


Examples:
|name        |language|address|
|Aarthy house|English |Annanagar|
#|Arun house  |Tamil   |Kodambakkam|
#|Rajikanna   |Telugu  |Choolaimedu| 

@DeletePlace @Regression
Scenario: Verify if Delete place functionality is working

Given DeletePlace payload

When user calls "deletePlaceAPI" with "post" http request

Then the API call got success with status code 200
And "status" in response body is "OK"


