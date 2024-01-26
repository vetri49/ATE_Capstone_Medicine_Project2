package com.simplilearn.restassured;

import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateMedicine {

	
	private static final String BASE_URL="http://localhost:9010";
	private static Logger logger=Logger.getLogger(UpdateMedicine.class);
	String response=null;
	@Test(description="Test to update the product in the store")
	public void testGetProduct() {
		try {
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
		logger.info("Start :: Test to update the product in the store");
		
		RestAssured.given().baseUri(BASE_URL)
		.contentType(ContentType.JSON).body(requestBody)
		.when().put("/update-product").then()
		.assertThat().statusCode(200)
		.body("message", equalTo("Disprin+ Updated Successfully."));
		
		
		response = RestAssured.given().baseUri(BASE_URL)
				.contentType(ContentType.JSON).body(requestBody)
		        .when().put("/update-product").getBody().asString();
	}catch(Exception e) {
		logger.error("Exception Object :: "+e.toString());
		logger.error("End Exception :: "+e.getLocalizedMessage());
	}
		logger.info("Reponse :: "+response);
		logger.info("End :: Test to update the product in the store");
	}
}
