package com.simplilearn.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProductSteps {

	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	@Given("the user is trying to create a product")
	public void the_user_is_trying_to_create_a_product() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("the user  is hit the create product url")
	public void the_user_is_hit_the_create_product_url() {
		String requestBody="{\r\n"
				+ "        \"id\": 999,\r\n"
				+ "        \"image\": \"1.png\",\r\n"
				+ "        \"name\": \"Disprin\",\r\n"
				+ "        \"category\": \"medicine\",\r\n"
				+ "        \"brand\": \"BZ Medico\",\r\n"
				+ "        \"status\": 1,\r\n"
				+ "        \"price\": 100\r\n"
				+ "}\r\n";
	    response=request.when().contentType(ContentType.JSON).body(requestBody).post("/add-product");
	}

	@Then("the system should confirm the successful creation of the medicine product")
	public void the_system_should_confirm_the_successful_creation_of_the_medicine_product() {
	    json=response.then().assertThat().statusCode(200);
	}

	@Then("check additional outcomes related to product creation")
	public void check_additional_outcomes_related_to_product_creation() {
	    System.out.println(response.getBody().asString());
	}
}
