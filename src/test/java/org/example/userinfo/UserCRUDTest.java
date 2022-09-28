package org.example.userinfo;


import io.restassured.response.Response;
import org.example.model.GorestPojo;
import org.example.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class UserCRUDTest extends TestBase {

    @Test
    public void Test1() {
        Response response=given()
                .when()
                .get("/public/v2/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void Test2() {
        Response response=given()
                .when()
                .get("/public/v2/users/2296");
        response.then();
        response.prettyPrint();
    }
    @Test
    public void Test3() {

        GorestPojo gorestPojo = new GorestPojo();
        gorestPojo.setName("sapna Ramakrishna");
        gorestPojo.setGender("male");
        gorestPojo.setEmail("tenali500.ramakrishna@15ce.com");
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
    @Test
    public void Test4(){
        GorestPojo gorestPojo = new GorestPojo();
        gorestPojo.setName("sapna Ramakrishna");
        gorestPojo.setGender("female");
        gorestPojo.setEmail("tenali05.ramakrishna@15ce.com");
        gorestPojo.setStatus("active");

        Response response=given()
                .basePath("/public/v2/users")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .pathParam("id",3671)
                .body(gorestPojo)
                .when()
                .patch("/{id}");
        response.then();
        response.prettyPrint();
    }
    @Test
    public void Test5(){
        Response response=given()
                .when()
                .delete("/public/v2/users/3671");
        response.then();
        response.prettyPrint();
    }


}
