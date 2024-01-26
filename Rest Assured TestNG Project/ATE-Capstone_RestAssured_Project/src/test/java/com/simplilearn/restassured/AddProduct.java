package com.simplilearn.restassured;

import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AddProduct {
	private static String BASE_URL = "http://localhost:9010";
    private static Logger logger = Logger.getLogger(AddProduct.class);
    String response = null;

    @Test(description = "Test to create a product")
    public void testAddProduct() {
        try {
            logger.info("Start :: Test to create a product ");
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

            RestAssured.given().baseUri(BASE_URL)
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when().post("/add-product")
                    .then().assertThat().statusCode(200)
                    .body("code",equalTo(101));

            response = RestAssured.given().baseUri(BASE_URL)
            		.contentType(ContentType.JSON)
                    .body(requestBody)
                    .when().post("/add-product")
                    .getBody().asString();
        } catch (Exception e) {
            logger.error("Exception Object :: " + e.toString());
            logger.error("End Exception :: " + e.getLocalizedMessage());
        }

        logger.info("Response :: " + response);
        logger.info("End :: Test to create a product");
    }

}
