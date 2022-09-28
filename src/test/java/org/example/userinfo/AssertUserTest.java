package org.example.userinfo;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class AssertUserTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);
    }
    //1.Total records are 10
    @Test
    public void verifytotal(){

    }
    //2.id 2492 has name = "Fr. Gatik Ahluwalia"
    @Test
    public void verifyname() {

            response.body("[0].id",hasKey("name"));


        }

    //3.id 2483 has email = "birjesh_acharya@brown.net"
    @Test
    public void verifyemail(){

    }
    //4.All ID has status = "active"
    @Test
    public void verifystatus(){

    }
    //5.id 2472 has gender = "female"
    @Test
    public void verifygender(){

    }
    //6.id 2471 has gender = "male"
    @Test
    public void verifygender1(){

    }
}
