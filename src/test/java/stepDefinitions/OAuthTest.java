package stepDefinitions;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class OAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "https://rahulshettyacademy.com/getCourse.php?state=aksdjfkdkf&code=4%2F0AeanS0YvE-m-6fGCaWBwQCYHnMfOAf7-1P3OHgh0IVIdsIlDB6YScAnXcWYuPtljX3gm_w&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=consent";
		String partialCode = url.split("code=")[1];
		String code = partialCode.split("&scope")[0];
		
		String accessTokenResponse = given().urlEncodingEnabled(false).queryParams("code", "code")
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();

		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");

		String response = given().queryParam("access_token", accessToken).when().log().all()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();

		System.out.println(response);
	}
}