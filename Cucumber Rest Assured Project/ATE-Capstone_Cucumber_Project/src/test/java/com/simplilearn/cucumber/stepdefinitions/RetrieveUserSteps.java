package com.simplilearn.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RetrieveUserSteps {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	@Given("the user has logged into the Medicare system")
	public void the_user_has_logged_into_the_medicare_system() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("the user initiates the {string} action")
	public void the_user_initiates_the_action(String string) {
	    response=request.get("/get-users");
	}

	@Then("the system should return a list of all users")
	public void the_system_should_return_a_list_of_all_users() {
	    json=response.then().statusCode(200);
	}

	@Then("the user can validate the details of each retrieved user")
	public void the_user_can_validate_the_details_of_each_retrieved_user() {
	    System.out.println(response.getBody().asPrettyString());
	}

}
