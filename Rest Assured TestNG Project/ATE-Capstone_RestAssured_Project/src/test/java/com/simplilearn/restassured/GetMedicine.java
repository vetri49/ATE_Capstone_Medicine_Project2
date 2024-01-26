package com.simplilearn.restassured;

import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetMedicine {
	private static final String BASE_URL="http://localhost:9010";
	private static Logger logger=Logger.getLogger(GetMedicine.class);
	String response=null;
	@Test(description="Test to get all the products from the store")
	public void testGetProduct() {
		try {
		logger.info("Start :: Test to get all the products from the store");
		RestAssured.given().baseUri(BASE_URL)
		.when().get("/get-products").then().statusCode(200).and()
		.body("code",equalTo(101));
		
		
		response = RestAssured.given().baseUri(BASE_URL)
		.when().get("/get-prodcuts").getBody().asString();
	}catch(Exception e) {
		logger.error("Exception Object :: "+e.toString());
		logger.error("End Exception :: "+e.getLocalizedMessage());
	}
		logger.info("Reponse :: "+response);
		logger.info("End :: Test to get all the products from the store");
	}

}
