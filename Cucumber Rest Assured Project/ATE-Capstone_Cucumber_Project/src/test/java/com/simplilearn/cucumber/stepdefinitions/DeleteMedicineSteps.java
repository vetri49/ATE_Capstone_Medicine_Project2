package com.simplilearn.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteMedicineSteps {
	
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	@Given("the user is logged into the product management system")
	public void the_user_is_logged_into_the_product_management_system() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("there is an existing medicine product to be deleted")
	public void there_is_an_existing_medicine_product_to_be_deleted() {
	    response=request.delete("/delete-product?id=999");
	}

	@Then("the system should confirm the successful deletion of the medicine product")
	public void the_system_should_confirm_the_successful_deletion_of_the_medicine_product() {
	    json=response.then().assertThat().statusCode(200);
	}

	@Then("the user can verify that the product is no longer available")
	public void the_user_can_verify_that_the_product_is_no_longer_available() {
	    System.out.println(response.getBody().asString());
	}

}
