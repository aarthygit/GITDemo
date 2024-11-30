package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		StepDefinition sd = new StepDefinition();
		if(StepDefinition.place_id==null) {
			
		sd.add_place_payload("lali", "malayali", "asia");
		sd.user_calls_with_post_http_request("AddPlaceAPI", "POST");
		sd.verify_place_Id_created_maps_to_using("lali", "getPlaceAPI");
		}
	}

}
