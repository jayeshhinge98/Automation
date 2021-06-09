package restassured_bdd.regresAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class RegresAPITesting {
		
	@Test
	public void test() {
		//RestAssured.basePath="";
		System.out.println("Testing Started");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//driver.get("https://reqres.in/api/users?page=2");
		//RestAssured.proxy("https://reqres.in/api/users?page=2");
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().get("https://reqres.in/api/users?page=2").then().log().all().statusCode(200).extract().response();
		
	}

}
