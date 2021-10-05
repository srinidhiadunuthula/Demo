package demo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Petswaggerapi {

    //private static final String addURI = "https://petstore.swagger.io/";


    private static Response response;
    @io.cucumber.java.en.


            Given("^I Set POST employee service api endpoint$")
    public void setPostEndpoint() {
        String addURI = "https://petstore.swagger.io/";
        System.out.println("Add URL :" + addURI);
    }


    @When("I add a pet to petstore")
    public void addpetInpetstore() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.header("accept", "application/json");
        request.body("{\n" +
                "  \"id\": 123,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"category1\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"dogs\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}");
        response = request.post("/pet");
        System.out.println("response for adding pet:" + response.getBody().prettyPrint());

    }

    @Then("The pet is added")
    public void petIsAdded() {
        Assert.assertEquals(200, response.getStatusCode());
    }


    @Then("I search for new pets")
    public void iSearchForNewPets() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.header("accept", "application/json");
        Pet pet = new Pet("", "", 123);

        response = request.get("/pet/" + pet.getId());
        System.out.println("response for searching pets: " + response.getBody().prettyPrint());
    }

    @Then("verify that image is uploaded")
    public void verifyThatImageIsUploaded() {
        given()
                .multiPart("file", new File("C:\\DemoRA\\src\\main\\resources\\Test.JPG"))
                .when()
                .post("https://petstore.swagger.io/v2/pet/123/uploadImage").then().body("code", equalTo(200));
    }
}
