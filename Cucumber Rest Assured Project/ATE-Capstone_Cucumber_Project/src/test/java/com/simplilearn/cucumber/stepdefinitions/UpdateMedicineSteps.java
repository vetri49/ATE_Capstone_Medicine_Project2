package com.simplilearn.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateMedicineSteps {
	
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	@Given("the user is on the update product page")
	public void the_user_is_on_the_update_product_page() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("modifies the details of the medicine product")
	public void modifies_the_details_of_the_medicine_product() {
		String requestBody="{\r\n"
				+ "        \"id\": 999,\r\n"
				+ "        \"image\": \"2.png\",\r\n"
				+ "        \"name\": \"Disprin+\",\r\n"
				+ "        \"category\": \"medicine\",\r\n"
				+ "        \"brand\": \"BZ Medico\",\r\n"
				+ "        \"status\": 1,\r\n"
				+ "        \"price\": 120\r\n"
				+ "}\r\n"
				+ "";
	    response=request.contentType(ContentType.JSON).body(requestBody).when().put("/update-product");
	}

	@Then("the system should confirm the successful update of the medicine product")
	public void the_system_should_confirm_the_successful_update_of_the_medicine_product() {
	    json=response.then().assertThat().statusCode(200);
	}

	@Then("check additional outcomes related to product updating")
	public void check_additional_outcomes_related_to_product_updating() {
	    System.out.println(response.getBody().asString());
	}

}
