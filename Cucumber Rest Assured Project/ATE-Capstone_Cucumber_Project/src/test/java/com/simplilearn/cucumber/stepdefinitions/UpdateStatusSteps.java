package com.simplilearn.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateStatusSteps {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	
	@Given("there is an existing medicine product")
	public void there_is_an_existing_medicine_product() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("selects a new status for the medicine")
	public void selects_a_new_status_for_the_medicine() {
		String requestBody="{\r\n"
				+ "        \"id\": 999,\r\n"
				+ "        \"image\": \"2.png\",\r\n"
				+ "        \"name\": \"Disprin+\",\r\n"
				+ "        \"category\": \"medicine\",\r\n"
				+ "        \"brand\": \"BZ Medico\",\r\n"
				+ "        \"status\": 0,\r\n"
				+ "        \"price\": 120\r\n"
				+ "}\r\n"
				+ "";
	    response=request.contentType(ContentType.JSON).body(requestBody).put("/update-product-status");
	}

	@Then("the system should confirm the successful update of the medicine status")
	public void the_system_should_confirm_the_successful_update_of_the_medicine_status() {
	   json=response.then().assertThat().statusCode(200);
	}

	@Then("the user can validate the updated status")
	public void the_user_can_validate_the_updated_status() {
	    System.out.println(response.getBody().asString());
	}
}
