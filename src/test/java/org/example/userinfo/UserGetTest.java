package org.example.userinfo;


import io.restassured.response.Response;
import org.example.testbase.TestBase;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class UserGetTest extends TestBase {

    @Test
    public void getAllUsersInfo() {
        Response response=given()
                .when()
                .get("/public/v2/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleuserInfo() {
    Response response=given()
            .when()
            .get("/public/v2/users/2524");
    response.then().statusCode(200);
    response.prettyPrint();
    }





}
