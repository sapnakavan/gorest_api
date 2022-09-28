package org.example.userinfo;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class AssertUserTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);
    }
    //1.Total records are 10

    @Test
    public void TotalRecord()
    {
        ArrayList<Integer> DataSize = response.extract().path("data");
        int size =DataSize.size();
        System.out.println("total record is :"+size);
        System.out.println("------------------------------------------------------");

    }
    //2.id 2266 has name = "Agnimitra Kakkar"
    @Test
    public  void  verifyname1(){
        response.body("[0].name",equalTo("Agnimitra Kakkar"));
        List<String> name1 = response.extract().path("data.findAll{it.id=='2266'}.name");
        System.out.println("List of name are : " + name1);
        System.out.println("------------------------------------------------------");
    }

    //3.id 2483 has email = "kakkar_agnimitra@schinner.org"
    @Test
    public void verifyemail(){
        response.body("[0].email",equalTo("kakkar_agnimitra@schinner.org"));
        List<String> email1 = response.extract().path("data.findAll{it.id=='2266'}.email");
        System.out.println("List of name are : " + email1);
        System.out.println("------------------------------------------------------");


    }
    //4.All ID has status = "active"
    @Test
    public void verifystatus(){
        response.body("[0].status",equalTo("active"));
        List<String> status = response.extract().path("data.findAll{it.id=='2266'}.status");
        System.out.println("List of name are : " + status);
        System.out.println("------------------------------------------------------");

    }
    //5.id 2472 has gender = "female"
    @Test
    public void verifygender(){
        response.body("[0].gender",equalTo("female"));
        List<String> gen2 = response.extract().path("data.findAll{it.id=='2266'}.gender");
        System.out.println("List of name are : " + gen2);
        System.out.println("------------------------------------------------------");
    }
    //6.id 2471 has gender = "male"
    @Test
    public void verifygender1(){
        response.body("[1].gender",equalTo("male"));
        List<String> gen1 = response.extract().path("data.findAll{it.id=='2265'}.gender");
        System.out.println("List of name are : " + gen1);
        System.out.println("------------------------------------------------------");
    }
}
