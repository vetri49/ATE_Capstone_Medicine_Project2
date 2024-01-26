package com.simplilearn.restassured;

import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class DeleteMedicine {
	
	private static final String BASE_URL="http://localhost:9010";
	private static Logger logger=Logger.getLogger(DeleteMedicine.class);
	String response=null;
	@Test(description="Test to delete product from the store")
	public void testDeleteProduct() {
		try {
		logger.info("Start :: Test to delete product from the store");
		int id=999;
		RestAssured.given().baseUri(BASE_URL)
		.when().delete("/delete-product?id="+id).then().statusCode(200).and()
		.body("message",equalTo("Product with ID "+id+" Deleted Successfully."));
		
		
		response = RestAssured.given().baseUri(BASE_URL)
		.when().delete("/delete-product?id="+id).getBody().asString();
	}catch(Exception e) {
		logger.error("Exception Object :: "+e.toString());
		logger.error("End Exception :: "+e.getLocalizedMessage());
	}
		logger.info("Reponse :: "+response);
		logger.info("End :: Test to delete product from the store");
	}

}
