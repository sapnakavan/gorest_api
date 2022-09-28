package org.example.userinfo;



import io.restassured.response.Response;
import org.example.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {

    @Test
    public void delete(){
        Response response=given()
                .when()
                .delete("/public/v2/users/3671");
        response.then();
        response.prettyPrint();
    }
}
