package com.simplilearn.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RetrieveMedicineSteps {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	@Given("the user is on the Medicare products page")
	public void the_user_is_on_the_medicare_products_page() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String string) {
	    response=request.when().get("/get-products");
	}

	@Then("all medicines should be displayed")
	public void all_medicines_should_be_displayed() {
      json=response.then().statusCode(200);
	}

	@Then("the user can check more details about each medicine")
	public void the_user_can_check_more_details_about_each_medicine() {
	   System.out.println(response.getBody().asString());
	}

}
