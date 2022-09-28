package org.example.userinfo;



import io.restassured.response.Response;
import org.example.model.GorestPojo;
import org.example.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class UserPatchTest extends TestBase {

    @Test
    public void updateUserWithPatch(){
        GorestPojo gorestPojo = new GorestPojo();
        gorestPojo.setName("sapna Ramakrishna");
        gorestPojo.setGender("female");
        gorestPojo.setEmail("tenali1501.ramakrishna@15ce.com");
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
}
