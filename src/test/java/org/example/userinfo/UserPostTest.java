package org.example.userinfo;



import io.restassured.response.Response;
import org.example.model.GorestPojo;
import org.example.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class UserPostTest extends TestBase {

    @Test
    public void createUser() {

        GorestPojo gorestPojo = new GorestPojo();
        gorestPojo.setName("sapna Ramakrishna");
        gorestPojo.setGender("male");
        gorestPojo.setEmail("tenali101.ramakrishna@15ce.com");
        gorestPojo.setStatus("active");


        Response response=given()
                .basePath("/public/v2/users")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .body(gorestPojo)
                .when()
                .post();
        response.then();
        response.prettyPrint();
    }
}
