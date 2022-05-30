package com.restapiexample.dummy.restapidummy;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllEmployeeRecord extends TestBase {
    @Test
    public void getAllEmployeesRecord(){
        Response response = given()
                .when()
                .get("/employees");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleEmployeeRecord(){
        Response response = given()
                .pathParam("id",5)
                .when()
                .get("/employee/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
