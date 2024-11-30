package resources;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class GraphQLScript {
	public static void main(String[] args) {

		// query
		int characterId = 14;

		String response = given().log().all().header("Content-Type", "application/json").body(
				"{\"query\":\"query($characterId : Int!, $episodeId : Int!)\\n{\\n  character(characterId: $characterId) {\\n    name\\n    gender\\n    id\\n  }\\n  location(locationId: 8) {\\n    name\\n    dimension\\n  }\\n  episode(episodeId: $episodeId) {\\n    name\\n    air_date\\n    episode\\n  }\\n  characters(filters: {name: \\\"Aarthy\\\"}) {\\n    info {\\n      count\\n    }\\n  }\\n  episodes(filters: {episode: \\\"hulu\\\"}) {\\n    result {\\n      id\\n      name\\n      air_date\\n      episode\\n    }\\n  }\\n}\\n\",\"variables\":{\"characterId\":"
						+ characterId + ",\"episodeId\":11578}}")
				.when().post("https://rahulshettyacademy.com/gq/graphql").then().extract().response().asString();

		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String characterName = js.getString("data.character.name");
	//	Assert.assertEquals(characterName, "bb");

		// mutations

		String mutationResponse = given().log().all().header("Content-Type", "application/json").body("{\r\n"
				+ "  \"query\": \"mutation ($locationName : String!, $characterName : String! , $episodeName : String!){\\n  createLocation(location: {name: $locationName, type: \\\"south\\\", dimension: \\\"234\\\"}) {\\n    id\\n  }\\n  createCharacter(character: {name: $characterName, type: \\\"good\\\", status: \\\"single\\\", species: \\\"human\\\", gender: \\\"male\\\", image: \\\"png\\\", originId: 1563362, locationId: 15662}) {\\n    id\\n  }\\n  \\n  createEpisode(episode: {name: $episodeName, air_date: \\\"12\\\", episode: \\\"14th episode\\\"}){\\n   id \\n  }\\n  \\n  deleteLocations(locationIds: [15667 , 14] ){\\n    locationsDeleted\\n  }\\n}\\n\",\r\n"
				+ "  \"variables\": {\r\n" + "    \"locationName\": \"Australia\",\r\n"
				+ "    \"characterName\": \"hero\",\r\n" + "    \"episodeName\": \"Money heist\"\r\n" + "  }\r\n" + "}")
				.when().post("https://rahulshettyacademy.com/gq/graphql").then().extract().response().asString();

		System.out.println(mutationResponse);
		

	}

}
