package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.TestDataCreation;
import resources.Utils;

public class regresAPIStepDef extends Utils {

	RequestSpecification reqs;
	Response response;
	TestDataCreation data =new TestDataCreation();

	
	@Given("{string} {string} is given as parameter")
	public void is_given_as_parameter(String param, String value) throws IOException {
		reqs=given().spec(requestSpecification()).queryParam(param, value);
	}

	@When("user calls {string} api using {string} request")
	public void user_calls_api_using_request(String resourceType, String method) throws IOException {
		
		 if(method.equalsIgnoreCase("GET")) {			
		 response=reqs.get(getResources(resourceType)).then().extract().response();}
		 else if(method.equalsIgnoreCase("POST"))
			 response=reqs.post(getResources(resourceType)).then().extract().response();
		 else if(method.equalsIgnoreCase("DELETE"))
			 response=reqs.delete(getResources(resourceType)).then().extract().response();
		 
	}

	@Then("status code should be {int}")
	public void status_code_should_be(Integer int1) {

		assertEquals(response.statusCode(),int1.intValue());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		assertEquals(getValueForKey(response, key), value);
	}

	@Given("{string} and {string} send as payload")
	public void and_send_as_payload(String name, String job) throws IOException {
		reqs=given().spec(requestSpecification()).body(data.createUser(name, job));
	}
	
	@Given("{string} as {string} send as payload")
	public void as_send_as_payload(String key, String value) throws IOException {
		reqs=given().spec(requestSpecification()).body(data.sendEmail(key, value));
	}

	@Then("verify {string} and {string} getting created using {string}")
	public void verify_and_getting_created(String name, String job,String resourceType) throws IOException {
			String id=getValueForKey(response, "id");	
			System.out.println("ID is "+id);
			reqs=given().spec(requestSpecification()).queryParam("id", id);
			user_calls_api_using_request(resourceType, "GET");
			//String actualname=getValueForKey(response, "name");
			//String actualjob=getValueForKey(response, "job");
			//System.out.println("For "+id+"the name "+actualname + "and "+actualjob+" generated...");
//			assertEquals(getValueForKey(response, "name"), name);		assertEquals(getValueForKey(response, "job"), job);
			
	}
}
