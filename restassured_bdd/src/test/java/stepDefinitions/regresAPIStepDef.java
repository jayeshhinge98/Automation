package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class regresAPIStepDef extends Utils{
	
	RequestSpecification reqs;
	Response response;
	
	@When("user calls {string} api using {string} request")
	public void user_calls_api_using_request(String resourceType, String method) throws IOException {
		reqs=given().spec(requestSpecification());
		 if(method.equalsIgnoreCase("GET"))
		 response=reqs.get(getResources(resourceType)).then().extract().response();
		 else if(method.equalsIgnoreCase("POST"))
			 response=reqs.post(getResources(resourceType)).then().extract().response();
		 
	}
	@Then("status code should be {int}")
	public void status_code_should_be(Integer int1) {
	    
	    assertEquals(int1.intValue(), response.statusCode());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		assertEquals(getValueForKey(response, key), value);
	}


}
